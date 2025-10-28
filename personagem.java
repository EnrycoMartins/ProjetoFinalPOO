public class Personagem {
    private String nome;
     private int pontosVida;
     private int ataque;
     private int defesa;
     private Inventario inventario;
     private Dado d20;
     private int dano;
    ///// Construtores /////
    public Personagem(String nome, int pv, int atq, int def, Inventario inventario, Dado d20, int dano)
    {
        setNome(nome);
        this.ataque = atq;
        this.defesa = def;
        this.pontosVida = pv;
        this.inventario = new Inventario(inventario);
        this.d20 = new Dado(20);
        this.dano = dano;
    }
    
    public Personagem(Personagem outro){
        this.nome = outro.nome;
        this.pontosVida = outro.pontosVida;
        this.ataque = outro.ataque;
        this.defesa = outro.defesa;
        this.inventario = new Inventario(outro.inventario);
        this.d20 = new Dado(20);
        this.dano = outro.dano;
    }


    ///// Setters /////
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome está vazio!");
        }
    }

    ///// Getters /////
    public String getNome() {
        return nome;
    }

    public int getPontosdeVida() {
        return pontosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public Inventario getInventario() {
        return inventario;
    }

    ///// Métodos /////
    protected int Atacar() {
        int RollDado = this.d20.rolar();
        int atqTotal = RollDado + this.ataque;

        System.out.println(this.nome + "ataca! (Rolagem:" + RollDado + ") + Bônus:" + this.ataque + "=" + atqTotal);
        return atqTotal;
    }

    protected void ReceberDano(int dano) {
        this.pontosVida -= dano;
        System.out.println(this.nome + " recebeu" + dano + "de dano! Vida atual:" + pontosVida);
    }

    protected int UsarItem() {
        
    }
}
