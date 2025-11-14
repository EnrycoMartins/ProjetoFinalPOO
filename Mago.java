public class Mago extends Personagem {
    private int mana;
    private int poderMagico;
    private final int MANA_MAXIMA = 100;
    
    // Custos de mana para cada feitiço
    private final int CUSTO_ESPINHOS = 20;
    private final int CUSTO_RELAMPAGO = 40;
    private final int CUSTO_TROVAO = 60;
    private final int CUSTO_EXPLOSAO = 80;
    private final int CUSTO_CICLO = 100;

    // Construtor 
    public Mago(String nome, int pvMax, int atq, int def, Inventario inventario, int poderMagico) {
        super(nome, pvMax, atq, def, inventario);
        this.mana = MANA_MAXIMA;
        this.poderMagico = poderMagico;
    }
    
    // Construtor simplificado
    public Mago(String nome) {
        super(nome, 80, 8, 10, new Inventario());
        this.mana = MANA_MAXIMA;
        this.poderMagico = 15;
    }
    
    public void EspinhosVermelhosDemoniacos(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        if (this.mana < CUSTO_ESPINHOS) {
            System.out.println(this.getNome() + " tentou usar Espinhos Vermelhos Demoníacos, mas não tem mana suficiente!");
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            super.atacar(inimigo);
            return;
        }

        this.mana -= CUSTO_ESPINHOS;
        System.out.println(getNome() + " lança ESPINHOS VERMELHOS DEMONÍACOS! 💢");
        System.out.println("(Mana restante: " + this.mana + "/" + MANA_MAXIMA + ")");

        // Rolagem de ataque mágico
        int rolagemAtaque = this.d20.rolar() + this.poderMagico;
        System.out.println("Rolagem de Ataque Mágico: (D20: " + (rolagemAtaque - this.poderMagico) + 
                         " + Poder Mágico: " + this.poderMagico + " = " + rolagemAtaque + ")");

        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU! Os espinhos perfuram " + inimigo.getNome() + "!");
            
            // Dano baseado no poder mágico
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.poderMagico;
            System.out.println("Dano Mágico: (D20: " + danoBase + " + Poder: " + this.poderMagico + " = " + danoTotal + " de dano)");
            
            inimigo.receberDano(danoTotal);
        } else {
            System.out.println("ERROU! " + inimigo.getNome() + " desviou dos espinhos!");
        }
        System.out.println("--------------------");
    }
    
    public void RelampagoDePlasma(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        if (this.mana < CUSTO_RELAMPAGO) {
            System.out.println(this.getNome() + " tentou usar Relâmpago de Plasma, mas não tem mana suficiente!");
            System.out.println(this.getNome() + " recorre a um ataque físico...");
            super.atacar(inimigo);
            return;
        }

        this.mana -= CUSTO_RELAMPAGO;
        System.out.println(getNome() + " conjura RELÂMPAGO DE PLASMA! ⚡");
        System.out.println("(Mana restante: " + this.mana + "/" + MANA_MAXIMA + ")");

        int rolagemAtaque = this.d20.rolar() + this.poderMagico + 2; // Bônus para relâmpago
        System.out.println("Rolagem de Ataque Mágico: (D20: " + (rolagemAtaque - this.poderMagico - 2) + 
                         " + Poder Mágico: " + this.poderMagico + " + Bônus Relâmpago: 2 = " + rolagemAtaque + ")");

        if (rolagemAtaque > inimigo.getDefesa()) {
            System.out.println("ACERTOU CRÍTICO! O plasma eletrocuta " + inimigo.getNome() + "!");
            
            int danoBase = this.d20.rolar();
            int danoTotal = danoBase + this.poderMagico + 5; // Dano extra do relâmpago
            System.out.println("Dano Mágico: (D20: " + danoBase + " + Poder: " + this.poderMagico + " + Bônus: 5 = " + danoTotal + " de dano)");
            
            inimigo.receberDano(danoTotal);
        } else {
            System.out.println("ERROU! O relâmpago atingiu o chão próximo a " + inimigo.getNome() + "!");
        }
        System.out.println("--------------------");
    }
    
    public void TrovaoAurora(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        if (this.mana < CUSTO_TROVAO) {
            System.out.println(this.getNome() + " tentou usar Trovão Aurora, mas não tem mana suficiente!");
            System.out.println("A magia falha...");
            return;
        }

        this.mana -= CUSTO_TROVAO;
        System.out.println(getNome() + " invoca TROVÃO AURORA! Seja aprisionado pelo gelo eterno! ❄️");
        System.out.println("(Mana restante: " + this.mana + "/" + MANA_MAXIMA + ")");

        // Ataque automático sem teste de acerto (magia de área)
        System.out.println("O trovão aurora atinge " + inimigo.getNome() + " automaticamente!");
        
        int danoBase = this.d20.rolar() + this.d20.rolar(); // 2d20 para dano maior
        int danoTotal = danoBase + this.poderMagico;
        System.out.println("Dano Congelante: (2D20: " + danoBase + " + Poder: " + this.poderMagico + " = " + danoTotal + " de dano)");
        
        inimigo.receberDano(danoTotal);
        
        // Aplica debuff de defesa ao inimigo
        inimigo.aplicarDebuffGeral(-3, 2); // -3 de ataque/defesa por 2 turnos
        System.out.println("--------------------");
    }
    
    public void ExplosaoDaCoroaSolar(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        if (this.mana < CUSTO_EXPLOSAO) {
            System.out.println(this.getNome() + " tentou usar Explosão da Coroa Solar, mas não tem mana suficiente!");
            System.out.println("A magia falha...");
            return;
        }

        this.mana -= CUSTO_EXPLOSAO;
        System.out.println(getNome() + " libera EXPLOSÃO DA COROA SOLAR!! DESAPAREÇA!! ☀️💥☀️");
        System.out.println("(Mana restante: " + this.mana + "/" + MANA_MAXIMA + ")");

        // Dano massivo sem teste de acerto
        System.out.println("A explosão solar incinera " + inimigo.getNome() + "!");
        
        int danoBase = this.d20.rolar() * 2; // Dano dobrado
        int danoTotal = danoBase + (this.poderMagico * 2);
        System.out.println("Dano Solar: (D20x2: " + danoBase + " + Poderx2: " + (this.poderMagico * 2) + " = " + danoTotal + " de dano)");
        
        inimigo.receberDano(danoTotal);
        System.out.println("--------------------");
    }
    
    public void CicloDasSeisExistencias(Personagem inimigo) {
        System.out.println("--- Turno de " + this.getNome() + " ---");
        
        if (this.mana < CUSTO_CICLO) {
            System.out.println(this.getNome() + " tentou usar Ciclo das Seis Existências, mas não tem mana suficiente!");
            System.out.println("A magia falha...");
            return;
        }

        this.mana -= CUSTO_CICLO;
        System.out.println(getNome() + " invoca CICLO DAS SEIS EXISTÊNCIAS! SOFRA PELA ETERNIDADE! 👻💀");
        System.out.println("(Mana restante: " + this.mana + "/" + MANA_MAXIMA + ")");

        // Dano extremo + debuff severo
        System.out.println("As almas do ciclo atormentam " + inimigo.getNome() + "!");
        
        int danoBase = this.d20.rolar() + this.d20.rolar() + this.d20.rolar(); // 3d20
        int danoTotal = danoBase + (this.poderMagico * 3);
        System.out.println("Dano Espiritual: (3D20: " + danoBase + " + Poderx3: " + (this.poderMagico * 3) + " = " + danoTotal + " de dano)");
        
        inimigo.receberDano(danoTotal);
        
        // Debuff severo
        inimigo.aplicarDebuffGeral(-8, 3); // -8 de ataque/defesa por 3 turnos
        System.out.println("--------------------");
    }
    
    public void descansar() {
        this.mana = MANA_MAXIMA;
        System.out.println(getNome() + " descansou e recuperou toda a mana!");
    }
    
    public int getMana() {
        return mana;
    }
    
    public int getPoderMagico() {
        return poderMagico;
    }
    
    // Método para ver status do mago
    public void verStatus() {
        System.out.println("Mago: " + getNome() + 
                         " | Vida: " + getPontosdeVida() + 
                         " | Mana: " + mana + "/" + MANA_MAXIMA +
                         " | Poder Mágico: " + poderMagico);
    }
    
    @Override
    public void processarBuffs() {
        super.processarBuffs(); // Processa buffs da classe pai
        
        // Regeneração natural de mana (1 por turno)
        if (this.mana < MANA_MAXIMA) {
            this.mana += 1;
            if (this.mana > MANA_MAXIMA) {
                this.mana = MANA_MAXIMA;
            }
        }
    }
}