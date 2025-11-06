public class Inimigo extends Personagem {

    private int bonusFuria = 3; 

    public Inimigo(String nome, int pvMax, int atq, int def, Inventario inventario) {
        super(nome, pvMax, atq, def, inventario);
    }
    
    public void decidirAcao(Personagem alvo) {
        // Rola o d20. Se tirar 15 ou mais, usa o ataque especial.
        int rolagemDecisao = this.d20.rolar();
        
        if (rolagemDecisao >= 15) {
            this.ataqueForte(alvo);
        } else {
            // Se não, usa o ataque normal (herdado de Personagem)
            super.atacar(alvo);
        }
    }

    public void ataqueForte(Personagem player) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        System.out.println(this.getNome() + " usa um ATAQUE FORTE!");
        
        // 1. ROLAGEM DE ATAQUE (com bônus de fúria)
        int rolagemAtaque = this.d20.rolar() + this.getAtaque() + this.bonusFuria;
        
        System.out.println("Rolagem de Ataque: (D20: " + (rolagemAtaque - this.getAtaque() - this.bonusFuria) + 
                           " + Bônus: " + this.getAtaque() + " + Fúria: " + this.bonusFuria + " = " + rolagemAtaque + ")");

        // 2. COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > player.getDefesa()) {
            System.out.println("ACERTOU COM FÚRIA!");
            
            // 3. ROLAGEM DE DANO (também com bônus)
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.getAtaque() + this.bonusFuria;
            System.out.println("Dano: (D20: " + danoBase + " + Bônus: " + this.getAtaque() + " + Fúria: " + this.bonusFuria + " = " + danoTotal + " de dano)");
            
            player.receberDano(danoTotal);
            
        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + player.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }
}