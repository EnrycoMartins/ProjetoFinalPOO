public class Mago extends Personagem {
    private int mana;
    
    // Construtor compatível com Personagem
    public Mago(String nome, int pv, int atq, int def, Inventario inventario, int dano) {
        super(nome, pv, atq, def, inventario, new Dado(20), dano);
        this.mana = 100; 
    }
    
    // Construtor
    public Mago(String nome) {
        super(nome, 80, 15, 8, new Inventario(), new Dado(20), 0);
        this.mana = 100;
    }
    
    public void EspinhosVermelhosDemoniacos() {
        if (this.mana >= 20) {
            this.mana -= 20;
            System.out.println(getNome() + " ESPINHOS VERMELHOS DEMONÍACOS! 💢 ");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
    
    public void RelampagoDePlasma() {
        if (this.mana >= 40) {
            this.mana -= 40;
            System.out.println(getNome() + " RELÂMPAGO DE PLASMA! ⚡");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
    
    public void TrovaoAurora() {
        if (this.mana >= 60) {
            this.mana -= 60;
            System.out.println(getNome() + " TROVÃO AURORA! ATAQUE! Seja aprisionado pelo gelo eterno! ❄️ ");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
    
    public void ExplosaoDaCoroaSolar() {
        if (this.mana >= 80) {
            this.mana -= 80;
            System.out.println(getNome() + " EXPLOSÃO DA COROA SOLAR!! DESAPAREÇA!! ☀️💥☀️ ");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
    
    public void ExplosaoGalactica() {
        if (this.mana >= 90) {
            this.mana -= 90;
            System.out.println(getNome() + " EXPLOSÃO GALÁCTICA! MORRA!!! 🌑🌀🌑 ");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
    
    public void CicloDasSeisExistencias() {
        if (this.mana >= 100) {
            this.mana -= 100;
            System.out.println(getNome() + " CICLO DAS SEIS EXISTÊNCIAS! SOFRA PELA ETERNIDADE NO MUNDO DOS MORTOS!!! 👻💀 ");
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
    
    public void descansar() {
        this.mana = 100; 
        System.out.println(getNome() + " descansou e recuperou a mana!");
    }
    
    public int getMana() {
        return mana;
    }
    
    // Método para ver status do mago
    public void verStatus() {
        System.out.println("Mago: " + getNome() + 
                         " | Vida: " + getPontosdeVida() + 
                         " | Mana: " + mana + "/100");
    }
}
