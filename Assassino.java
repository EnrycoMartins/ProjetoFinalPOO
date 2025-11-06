public final class Assassino extends Personagem {
    private int stamina;

    //// Construtor /////
    public Assassino(String nome, int pv, int atq, int def, Inventario inventario, int stamina) {
        super(nome, pv, atq, def, inventario);
        setStamina(stamina);
    }
    
    //// Setters ////
    public void setStamina(int stamina) {
        if (stamina < 0) {
            this.stamina = 0;
        }
        else {
            this.stamina = stamina;
        }
    }

    //// Getters /////
    public int getStamina() { return stamina; }

    //// Métodos de Ataque ////
    
    //// Assassino(a) vai atirar com a besta
    public void AtirarBestaLaminadoCaos(Personagem inimigo) {
        final int CUSTO_STAMINA_BESTA = 2;
        final int BONUS_ATAQUE_BESTA = 4;
        System.out.println("--- Turno de " + this.getNome() + " ---");

        if (this.getStamina() < CUSTO_STAMINA_BESTA) {
            System.out.println(this.getNome() + " não tem stamina suficiente para atirar com a besta! Stamina: " + this.getStamina());
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            super.atacar(inimigo); //
            return; // Encerra o turno
        }

        this.setStamina(this.getStamina() - CUSTO_STAMINA_BESTA);

        // ROLAGEM DE ATAQUE (Para Acertar)
        int RollDado = this.d20.rolar(); 
        int rolagemAtaque = RollDado + this.getAtaque() + BONUS_ATAQUE_BESTA;

        System.out.println(this.getNome() + " atira com a besta da lâmina do caos!");
        System.out.println("(Rolagem:" + RollDado + ") + Bônus:" + this.getAtaque() + " + Besta:" + BONUS_ATAQUE_BESTA + " = " + rolagemAtaque);
        
        // COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");

            // ROLAGEM DE DANO (Se Acertou)
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.getAtaque(); // Dano baseado no Ataque (como no Personagem)
            System.out.println("Dano: (D20: " + danoBase + " + Bônus: " + this.getAtaque() + " = " + danoTotal + " de dano)");
            
            inimigo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }

    //// Assassino(a) vai realizar uma estocada prescisa no pescoço do inimigo
    public void EstocadaPescocoLaminadoCaos(Personagem inimigo) {
        final int CUSTO_STAMINA_ESTOCADA = 4;
        final int BONUS_ATAQUE_ESTOCADA = 8;
        System.out.println("--- Turno de " + this.getNome() + " ---");

        if (this.getStamina() < CUSTO_STAMINA_ESTOCADA) {
            System.out.println(this.getNome() + " não tem stamina suficiente para a estocada! Stamina: " + this.getStamina());
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            super.atacar(inimigo); //
            return; // Encerra o turno
        }

        this.setStamina(this.getStamina() - CUSTO_STAMINA_ESTOCADA);

        // ROLAGEM DE ATAQUE (Para Acertar)
        int RollDado = this.d20.rolar(); 
        int rolagemAtaque = RollDado + this.getAtaque() + BONUS_ATAQUE_ESTOCADA;

        System.out.println(this.getNome() + " avança para uma estocada no pescoço com a lâmina do caos!");
        System.out.println("(Rolagem:" + RollDado + ") + Bônus:" + this.getAtaque() + " + Estocada:" + BONUS_ATAQUE_ESTOCADA + " = " + rolagemAtaque);
        
        // COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");

            // ROLAGEM DE DANO (Se Acertou)
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.getAtaque(); 
            System.out.println("Dano: (D20: " + danoBase + " + Bônus: " + this.getAtaque() + " = " + danoTotal + " de dano)");
            
            inimigo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }

    //// Assassino(a) vai lançar facas de arremeço no inimigo
    public void LancarFacas(Personagem inimigo) {
        final int CUSTO_STAMINA_FACAS = 1;
        final int BONUS_ATAQUE_FACAS = 2;
        System.out.println("--- Turno de " + this.getNome() + " ---");

        if (this.getStamina() < CUSTO_STAMINA_FACAS) {
            System.out.println(this.getNome() + " não tem stamina suficiente para lançar facas! Stamina: " + this.getStamina());
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            super.atacar(inimigo); //
            return; // Encerra o turno
        }

        this.setStamina(this.getStamina() - CUSTO_STAMINA_FACAS);

        // ROLAGEM DE ATAQUE (Para Acertar)
        int RollDado = this.d20.rolar(); 
        int rolagemAtaque = RollDado + this.getAtaque() + BONUS_ATAQUE_FACAS; 

        System.out.println(this.getNome() + " lança um conjunto de facas de arremesso!");
        System.out.println("(Rolagem:" + RollDado + ") + Bônus:" + this.getAtaque() + " + Facas:" + BONUS_ATAQUE_FACAS + " = " + rolagemAtaque);
        
        // COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");

            // ROLAGEM DE DANO (Se Acertou)
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.getAtaque(); 
            System.out.println("Dano: (D20: " + danoBase + " + Bônus: " + this.getAtaque() + " = " + danoTotal + " de dano)");
            
            inimigo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }

    //// Assassino(a) vai lançar uma bomba de fumaça e atacar o inimigo
    public void AtaqueComBombaDeFumaca(Personagem inimigo) {
        final int CUSTO_STAMINA_FUMACA = 3;
        final int BONUS_ATAQUE_FUMACA = 6; 
        System.out.println("--- Turno de " + this.getNome() + " ---");

        if (this.getStamina() < CUSTO_STAMINA_FUMACA) {
            System.out.println(this.getNome() + " não tem stamina suficiente para a bomba de fumaça! Stamina: " + this.getStamina());
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            super.atacar(inimigo); //
            return; // Encerra o turno
        }

        this.setStamina(this.getStamina() - CUSTO_STAMINA_FUMACA);

        // ROLAGEM DE ATAQUE (Para Acertar)
        int RollDado = this.d20.rolar(); 
        int rolagemAtaque = RollDado + this.getAtaque() + BONUS_ATAQUE_FUMACA; 

        System.out.println(this.getNome() + " joga uma bomba de fumaça e ataca no meio da confusão!");
        System.out.println("(Rolagem:" + RollDado + ") + Bônus:" + this.getAtaque() + " + Fumaça:" + BONUS_ATAQUE_FUMACA + " = " + rolagemAtaque);
        
        // COMPARAÇÃO COM DEFESA
        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! (Rolagem " + rolagemAtaque + " > Defesa " + inimigo.getDefesa() + ")");

            // ROLAGEM DE DANO (Se Acertou)
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.getAtaque(); 
            System.out.println("Dano: (D20: " + danoBase + " + Bônus: " + this.getAtaque() + " = " + danoTotal + " de dano)");
            
            inimigo.receberDano(danoTotal);

        } else {
            System.out.println("ERROU! (Rolagem " + rolagemAtaque + " <= Defesa " + inimigo.getDefesa() + ")");
        }
        System.out.println("--------------------");
    }
}