import java.util.List; 

public class Bruxo extends Personagem {

    private int pontosDeSinal;
    private final int pontosDeSinalMaximo = 6; 
    private int poderDeSinal; 
    private final int CUSTO_IGNI = 1; 

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

    @Override
    public void usarItem(String nomeDoItem) {
        List<Item> itensEncontrados = this.inventario.getItensPorNome(nomeDoItem);
        
        if (itensEncontrados.isEmpty()) {
            System.out.println(this.getNome() + " tentou usar '" + nomeDoItem + "', mas não o possui.");
            return;
        }

        // 2. LÓGICA DO BRUXO: Procurar primeiro por itens de SINAL
        Item itemDeSinal = null;
        for (Item item : itensEncontrados) {
            if (item.getEfeito() == Efeito.CURA_SINAL) {
                itemDeSinal = item;
                break; 
            }
        }

        // 3. Se encontrou um item de Sinal, usa e encerra o método
        if (itemDeSinal != null) {
            System.out.println(this.getNome() + " usa " + itemDeSinal.getNome() + "!");
            this.restaurarSinal(itemDeSinal.getEfeito().getValor()); 
            this.inventario.remover(itemDeSinal.getNome(), itemDeSinal.getEfeito(), 1);
            return; 
        }

        System.out.println(this.getNome() + " não usou um item de Sinal, verificando poções comuns...");
        super.usarItem(nomeDoItem); // O Personagem usarara CURA, BUFF_ATAQUE, etc.
    }
    public void lancarIgni(Personagem alvo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        // 1. VERIFICA SINAIS
        if (this.pontosDeSinal < CUSTO_IGNI) {
            System.out.println(this.getNome() + " tentou usar Igni, mas não tem Sinais suficientes!");
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            
            super.atacar(alvo); 
            return; // Encerra o turno
        }
        // Se tem Sinais, gasta e ataca
        this.pontosDeSinal -= CUSTO_IGNI;
        System.out.println(this.getNome() + " lança o sinal Igni contra " + alvo.getNome() + "!");
        System.out.println("(Sinais restantes: " + this.pontosDeSinal + "/" + this.pontosDeSinalMaximo + ")");

        // 2. ROLAGEM DE ATAQUE MÁGICO (Para Acertar)
        int rolagemAtaque = this.d20.rolar() + this.poderDeSinal; // d20 + Bônus de Poder de Sinal
        System.out.println("Rolagem de Ataque Mágico: (D20: " + (rolagemAtaque - this.poderDeSinal) + 
                           " + Poder: " + this.poderDeSinal + " = " + rolagemAtaque + ")");

        // 3. COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > alvo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + alvo.getDefesa() + ")");

            // 4. ROLAGEM DE DANO (Se Acertou)
            // Vamos rolar o d20 de novo para o dano + poder de sinal
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.poderDeSinal;
            System.out.println("Dano de Fogo: (D20: " + danoBase + " + Poder: " + this.poderDeSinal + " = " + danoTotal + " de dano)");
            
            // Aplica o dano ao alvo
            alvo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + alvo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }
}