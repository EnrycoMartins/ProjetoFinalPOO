import java.util.List;

public abstract class Personagem {
    
    private String nome;
    private int pontosVida;
    private int pontosVidaMaximos; 
    private int ataque;
    private int defesa;
    protected Inventario inventario; 
    protected Dado d20;       
    protected int turnosBuffDefesa = 0; // Contador de turnos   
    protected int turnosDebuffGeral = 0; // Contador de turnos
    protected int valorDebuffGeral = 0;  

    public Personagem(String nome, int pvMax, int atq, int def, Inventario inventario) {
        setNome(nome);
        this.pontosVidaMaximos = pvMax;
        this.pontosVida = pvMax; 
        this.ataque = atq;
        this.defesa = def;
        this.inventario = new Inventario(inventario);
        this.d20 = new Dado(20); 
    }
    
    // --- Getters e Setters ---
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome está vazio!");
        }
        this.nome = nome; 
    }

    public Inventario getInventario() {return this.inventario;}
    public int getPontosdeVida() {return this.pontosVida;}
    public int getPontosdeVidaMaximos() {return this.pontosVidaMaximos;}
    public String getNome() { return nome; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    
    public void aplicarBuffDefesa(int valorBuff, int duracao) {
        // Só aplica o buff se não houver um ativo
        if (this.turnosBuffDefesa == 0) {
            this.setDefesa(this.getDefesa() + valorBuff);
            System.out.println("⭐ " + this.getNome() + " ganha +" + valorBuff + " de Defesa!");
        } else {
            System.out.println("⭐ " + this.getNome() + " renova seu buff de defesa!");
        }
        // Define (ou reinicia) a duração
        this.turnosBuffDefesa = duracao;
    }

    public void aplicarDebuffGeral(int valorDebuff, int duracao) {
        // Só aplica o debuff se não houver um ativo
        if (this.turnosDebuffGeral == 0) {
            this.valorDebuffGeral = valorDebuff; // Salva o valor (ex: -5)
            this.setAtaque(this.getAtaque() + valorDebuff); // atk + (-5)
            this.setDefesa(this.getDefesa() + valorDebuff); // def + (-5)
            System.out.println("😵 " + this.getNome() + " é afetado por Axii! Ataque e Defesa -" + Math.abs(valorDebuff) + "!");
        } else {
            System.out.println("😵 " + this.getNome() + " renova o debuff de Axii!");
        }
        // Define ou reinicia a duração
        this.turnosDebuffGeral = duracao;
    }
    // --- Métodos de combate ---
    public void atacar(Personagem inimigo) {
    System.out.println("--- Turno de " + this.getNome() + " ---");
    
    // 1. ROLAGEM DE ATAQUE (Para Acertar)
    int rolagemAtaque = this.d20.rolar() + this.getAtaque(); // d20 + Bônus de Ataque
    System.out.println(this.getNome() + " ataca " + inimigo.getNome() + "!");
    System.out.println("Rolagem de Ataque: (D20: " + (rolagemAtaque - this.getAtaque()) + 
                       " + Bônus: " + this.getAtaque() + " = " + rolagemAtaque + ")");

    // 2. COMPARAÇÃO COM DEFESA
    if (rolagemAtaque > inimigo.getDefesa()) {
        System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");
        
        // 3. ROLAGEM DE DANO (Se Acertou)
        // Re-rolar o d20 para o dano + bônus de ataque
        int danoBase = this.d20.rolar();
        int danoTotal = danoBase + this.getAtaque();
        System.out.println("Dano: (D20: " + danoBase + " + Bônus: " + this.getAtaque() + " = " + danoTotal + " de dano)");
        
        // Aplica o dano ao alvo
        inimigo.receberDano(danoTotal);
        
    } else {
        System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
    }
    System.out.println("--------------------");
}

    protected void receberDano(int dano) {
        this.pontosVida -= dano;
        if (this.pontosVida < 0) this.pontosVida = 0;
        System.out.println(this.nome + " recebeu " + dano + " de dano! Vida atual: " + pontosVida);
    }
    
    public void receberCura(int cura) {
        this.pontosVida += cura;
        if (this.pontosVida > this.pontosVidaMaximos) {
            this.pontosVida = this.pontosVidaMaximos;
        }
        System.out.println(this.nome + " curou " + cura + " PV! Vida atual: " + this.pontosVida);
   }

    public void usarItem(String nomeDoItem) {
        List<Item> itensEncontrados = this.inventario.getItensPorNome(nomeDoItem);

        if (itensEncontrados.isEmpty()) {
            System.out.println(this.getNome() + " tentou usar '" + nomeDoItem + "', mas não o possui.");
            return;
        }

        Item itemParaUsar = null;
        for (Item item : itensEncontrados) {
            Efeito ef = item.getEfeito();
            if (ef == Efeito.CURA || ef == Efeito.BUFF_ATAQUE || ef == Efeito.BUFF_DEFESA) {
                itemParaUsar = item; 
                break; 
            }
        }

        if (itemParaUsar == null) {
            System.out.println(this.getNome() + " tem '" + nomeDoItem + "', mas não sabe como usá-lo.");
            return;
        }

        Efeito efeito = itemParaUsar.getEfeito();
        int valor = efeito.getValor();
        System.out.println(this.getNome() + " usa " + itemParaUsar.getNome() + "!");

        switch (efeito) {
            case CURA:
                this.receberCura(valor);
                break;
            case BUFF_ATAQUE:
                this.setAtaque(this.getAtaque() + valor);
                System.out.println(this.getNome() + " sente seu ataque aumentar! (Ataque: " + this.getAtaque() + ")");
                break;
            case BUFF_DEFESA:
                this.setDefesa(this.getDefesa() + valor);
                System.out.println(this.getNome() + " sente sua defesa aumentar! (Defesa: " + this.getDefesa() + ")");
                break;
            default:
                return; 
        }

        this.inventario.remover(itemParaUsar.getNome(), itemParaUsar.getEfeito(), 1);
    }

    public void processarBuffs() {
        // --- Processa Buff de Defesa  ---
        if (this.turnosBuffDefesa > 0) {
            this.turnosBuffDefesa--; // Reduz a duração

            System.out.println("   (Buff de Defesa de " + this.getNome() + ": " + this.turnosBuffDefesa + " turnos restantes)");

            // Se o buff acabou de expirar (chegou a 0)
            if (this.turnosBuffDefesa == 0) {
                int valorBuff = Efeito.BUFF_DEFESA.getValor(); // Pega o valor (5)
                this.setDefesa(this.getDefesa() - valorBuff); // Remove o bônus
                System.out.println("💨 O buff de Defesa de " + this.getNome() + " expirou!");
            }
        }

        // --- Processa Debuff Geral  ---
        if (this.turnosDebuffGeral > 0) {
            this.turnosDebuffGeral--; // Reduz a duração

            System.out.println("   (Debuff de status em " + this.getNome() + ": " + this.turnosDebuffGeral + " turnos restantes)");

            // Se o buff acabou de expirar (chegou a 0)
            if (this.turnosDebuffGeral == 0) {
                // Remove o debuff (subtrai o valor negativo, ex: atk - (-5) = atk + 5)
                System.out.println("✨ " + this.getNome() + " se recupera do Status Negativo!");
                this.setAtaque(this.getAtaque() - this.valorDebuffGeral); 
                this.setDefesa(this.getDefesa() - this.valorDebuffGeral);
                this.valorDebuffGeral = 0; // Zera o valor
            }
        }
    }
}