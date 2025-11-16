import java.util.List; 

public class Bruxo extends Personagem {

    private int pontosDeSinal;
    private final int pontosDeSinalMaximo = 10; 
    private int poderDeSinal; 
    private final int CUSTO_IGNI = 2; 
    private final int CUSTO_AARD = 1;
    private final int CUSTO_QUEN = 2;
    private final int CUSTO_AXII = 3;

    public Bruxo(String nome, int pv, int atq, int def, Inventario inventario, int poderDeSinal) {
        super(nome, pv, atq, def, inventario); 
        this.pontosDeSinal = this.pontosDeSinalMaximo; 
        this.poderDeSinal = poderDeSinal;
    }

    public void restaurarSinal(int quantidade) {
        this.pontosDeSinal += quantidade;
        if (this.pontosDeSinal > this.pontosDeSinalMaximo) {
            this.pontosDeSinal = this.pontosDeSinalMaximo;
        }
        System.out.println(this.getNome() + " restaurou " + quantidade + " Ponto(s) de Sinal! (Total: " + this.pontosDeSinal + ")");
    }   

    public int getPontosDeSinal() {
        return this.pontosDeSinal;
    }

    @Override
    public void usarItem(String nomeDoItem) {
        List<Item> itensEncontrados = this.inventario.getItensPorNome(nomeDoItem);
        
        if (itensEncontrados.isEmpty()) {
            System.out.println(this.getNome() + " tentou usar '" + nomeDoItem + "', mas não o possui.");
            return;
        }

        // Procurar primeiro por itens de SINAL
        Item itemDeSinal = null;
        for (Item item : itensEncontrados) {
            if (item.getEfeito() == Efeito.CURA_SINAL) {
                itemDeSinal = item;
                break; 
            }
        }

        // Se encontrou um item de Sinal, usa e encerra 
        if (itemDeSinal != null) {
            System.out.println(this.getNome() + " usa " + itemDeSinal.getNome() + "!");
            this.restaurarSinal(itemDeSinal.getEfeito().getValor()); 
            this.inventario.remover(itemDeSinal.getNome(), itemDeSinal.getEfeito(), 1);
            return; 
        }

        System.out.println(this.getNome() + " não usou um item de Sinal, verificando poções comuns...");
        super.usarItem(nomeDoItem); // O Personagem usarara CURA, BUFF_ATAQUE, etc.
    }
    public void lancarIgni(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        // VERIFICA SINAIS
        if (this.pontosDeSinal < CUSTO_IGNI) {
            System.out.println(this.getNome() + " tentou usar Igni, mas não tem Sinais suficientes!");
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            
            super.atacar(inimigo); 
            return; // Encerra o turno
        }
        // Se tem Sinais, gasta e ataca
        this.pontosDeSinal -= CUSTO_IGNI;
        System.out.println(this.getNome() + " lança o sinal Igni contra " + inimigo.getNome() + "!");
        System.out.println("(Sinais restantes: " + this.pontosDeSinal + "/" + this.pontosDeSinalMaximo + ")");

        // ROLAGEM DE ATAQUE(Para Acertar)
        int rolagemAtaque = this.d20.rolar() + this.poderDeSinal; // d20 + Bônus de Poder de Sinal
        System.out.println("Rolagem de Ataque Mágico: (D20: " + (rolagemAtaque - this.poderDeSinal) + 
                           " + Poder: " + this.poderDeSinal + " = " + rolagemAtaque + ")");

        // COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");

            // ROLAGEM DE DANO (Se Acertou)
            // Rola o d20 de novo para o dano + poder de sinal
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.poderDeSinal + 6;
            System.out.println("Dano de Fogo: (D20: " + danoBase + " + Poder: " + this.poderDeSinal +" + 6 "+ " = " + danoTotal + " de dano)");
            
            // Aplica o dano no inimigo
            inimigo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }
    public void lancarAard(Personagem inimigo) {
        // VERIFICA SINAIS
        if (this.pontosDeSinal < CUSTO_AARD) {
            System.out.println(this.getNome() + " tentou usar Aard, mas não tem Sinais suficientes!");
            System.out.println(this.getNome() + " recorre a um ataque físico...");
        
            super.atacar(inimigo); 
            return; // Encerra o turno
        }
        // Se tem Sinais, gasta e ataca
        this.pontosDeSinal -= CUSTO_AARD;
        System.out.println(this.getNome() + " lança o sinal aard contra " + inimigo.getNome() + "!");
        System.out.println("(Sinais restantes: " + this.pontosDeSinal + "/" + this.pontosDeSinalMaximo + ")");

        // ROLAGEM DE ATAQUE(Para Acertar)
        int rolagemAtaque = this.d20.rolar() + this.poderDeSinal; // d20 + Bônus de Poder de Sinal
        System.out.println("Rolagem de Ataque Mágico: (D20: " + (rolagemAtaque - this.poderDeSinal) + 
                           " + Poder: " + this.poderDeSinal + " = " + rolagemAtaque + ")");

        // COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");

            // ROLAGEM DE DANO (Se Acertou)
            // Rola o d20 de novo para o dano + poder de sinal
            int danoBase = this.d20.rolar();
            int danoTotal = (danoBase + this.poderDeSinal + 3);
            System.out.println("Dano de Vento: (D20: " + danoBase + " + Poder: " + this.poderDeSinal +" + 3 "+ " = " + danoTotal + " de dano)");
            
            // Aplica o dano ao inimigo
            inimigo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }
    public void lancarQuen() {
        // VERIFICA SINAIS
        if (this.pontosDeSinal < CUSTO_QUEN) {
            System.out.println(this.getNome() + " tentou usar Quen, mas não tem Sinais suficientes!");
            System.out.println("A magia falha...");
            // O turno é gasto mesmo se falhar
            return; 
        }
        // GASTA SINAIS E APLICA O BUFF
        this.pontosDeSinal -= CUSTO_QUEN;
        System.out.println(this.getNome() + " usa o sinal Quen!");
        System.out.println("(Sinais restantes: " + this.pontosDeSinal + "/" + this.pontosDeSinalMaximo + ")");

        // PEGA OS VALORES
        int valorBuff = Efeito.BUFF_DEFESA.getValor(); // Pega o valor 5 do Enum
        int duracao = 3; // O buff dura 2 turnos

        // Só o Bruxo recebe o buff
        this.aplicarBuffDefesa(valorBuff, duracao);
        
        System.out.println("--------------------");
    }

    public void lancarAxii(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        // VERIFICA SINAIS 
        if (this.pontosDeSinal < CUSTO_AXII) {
            System.out.println(this.getNome() + " tentou usar Axii, mas não tem Sinais suficientes!");
            System.out.println("A magia falha...");
            return; // Turno gasto
        }

        // GASTA SINAIS
        this.pontosDeSinal -= CUSTO_AXII;
        System.out.println(this.getNome() + " usa o sinal Axii contra " + inimigo.getNome() + "!");
        System.out.println("(Sinais restantes: " + this.pontosDeSinal + "/" + this.pontosDeSinalMaximo + ")");

        // DEFINE OS VALORES DO DEBUFF
        int valorDebuff = -5; // O debuff de -5
        int duracao = 3;    // 3 turnos

        // Coloca o debuff no inimigo
        inimigo.aplicarDebuffGeral(valorDebuff, duracao);
        
        System.out.println("--------------------");
    }
    public void restaurarSinaisTotalmente() {
        this.pontosDeSinal = this.pontosDeSinalMaximo;
        System.out.println("✨ " + this.getNome() + " teve seus Sinais totalmente restaurados! (" + this.pontosDeSinalMaximo + " Sinais)");
    }

}