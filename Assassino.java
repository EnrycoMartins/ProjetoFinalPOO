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

    /**
     * Dispara a besta acoplada na lâmina do caos.
     * Custo de Stamina: 2
     * Bônus de Ataque: +4
     */
    public int AtirarBestaLaminadoCaos() {
        final int CUSTO_STAMINA_BESTA = 2;
        final int BONUS_ATAQUE_BESTA = 4;

        if (this.getStamina() < CUSTO_STAMINA_BESTA) {
            System.out.println(this.getNome() + " não tem stamina suficiente para atirar com a besta! Stamina: " + this.getStamina());
            return 0; // Ataque falha
        }

        // Gasta a stamina
        this.setStamina(this.getStamina() - CUSTO_STAMINA_BESTA);

        // Rola o dado e calcula o ataque
        // Isso funciona pois 'd20' é 'protected' em Personagem.java
        int RollDado = this.d20.rolar(); 
        int atqTotal = RollDado + this.getAtaque() + BONUS_ATAQUE_BESTA;

        System.out.println(this.getNome() + " atira com a besta da lâmina do caos!");
        System.out.println("(Rolagem:" + RollDado + ") + Bônus:" + this.getAtaque() + " + Besta:" + BONUS_ATAQUE_BESTA + " = " + atqTotal);
        
        return atqTotal;
    }

    /**
     * Realiza uma estocada precisa no pescoço com a lâmina do caos.
     * Custo de Stamina: 4
     * Bônus de Ataque: +8
     */
    public int EstocadaPescocoLaminadoCaos() {
        final int CUSTO_STAMINA_ESTOCADA = 4;
        final int BONUS_ATAQUE_ESTOCADA = 8; // Bônus alto para um golpe difícil

        if (this.getStamina() < CUSTO_STAMINA_ESTOCADA) {
            System.out.println(this.getNome() + " não tem stamina suficiente para a estocada! Stamina: " + this.getStamina());
            return 0; // Ataque falha
        }

        // Gasta a stamina
        this.setStamina(this.getStamina() - CUSTO_STAMINA_ESTOCADA);

        // Rola o dado e calcula o ataque
        // Isso funciona pois 'd20' é 'protected' em Personagem.java
        int RollDado = this.d20.rolar(); 
        int atqTotal = RollDado + this.getAtaque() + BONUS_ATAQUE_ESTOCADA;

        System.out.println(this.getNome() + " avança para uma estocada no pescoço com a lâmina do caos!");
        System.out.println("(Rolagem:" + RollDado + ") + Bônus:" + this.getAtaque() + " + Estocada:" + BONUS_ATAQUE_ESTOCADA + " = " + atqTotal);
        
        return atqTotal;
    }
}