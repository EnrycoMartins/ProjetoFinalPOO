import java.util.List;

public abstract class Personagem {
    
    private String nome;
    private int pontosVida;
    private int pontosVidaMaximos; 
    private int ataque;
    private int defesa;
    protected Inventario inventario; // Protected para subclasses
    protected Dado d20;             // Protected para subclasses

    public Personagem(String nome, int pvMax, int atq, int def, Inventario inventario) {
        setNome(nome);
        this.pontosVidaMaximos = pvMax;
        this.pontosVida = pvMax; 
        this.ataque = atq;
        this.defesa = def;
        this.inventario = new Inventario(inventario); // Cria cópia
        this.d20 = new Dado(20); // O Personagem cria seu D20
    }
    
    // (Construtor de cópia, Getters, Setters, atacar(), receberDano(), receberCura()...)
    // (Coloque aqui os outros métodos da classe Personagem)
    
    // --- Getters e Setters necessários ---
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome está vazio!");
        }
        this.nome = nome; 
    }
    public String getNome() { return nome; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    
    // --- Métodos de combate ---
    public void atacar(Personagem inimigo) {
    System.out.println("--- Turno de " + this.getNome() + " ---");
    
    // 1. ROLAGEM DE ATAQUE (Para Acertar)
    int rolagemAtaque = this.d20.rolar() + this.getAtaque(); // d20 + Bônus de Ataque
    System.out.println(this.getNome() + " ataca " + inimigo.getNome() + "!");
    System.out.println("Rolagem de Ataque: (D20: " + (rolagemAtaque - this.getAtaque()) + 
                       " + Bônus: " + this.getAtaque() + " = " + rolagemAtaque + ")");

    // 2. COMPARAÇÃO COM DEFESA
    // (Usando "maior que", como você pediu)
    if (rolagemAtaque > inimigo.getDefesa()) {
        System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");
        
        // 3. ROLAGEM DE DANO (Se Acertou)
        // Vamos re-rolar o d20 para o dano + bônus de ataque
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
}