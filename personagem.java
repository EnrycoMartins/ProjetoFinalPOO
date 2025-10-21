public class Personagem {
    private String nome;
     private int pontosVida;
     private int ataque;
     private int defesa;
     private Inventario inventario;
    ///// Construtores /////
    public Personagem(String nome, int pv, int atq, int def, Inventario inventario)
    {
        setNome(nome);
        this.ataque = atq;
        this.defesa = def;
        this.pontosVida = pv;
        this.inventario = new Inventario(inventario);
    }
    
    public Personagem(Personagem outro){
        this.nome = outro.nome;
        this.pontosVida = outro.pontosVida;
        this.ataque = outro.ataque;
        this.defesa = outro.defesa;
        this.inventario = new Inventario(outro.inventario);
    }


    ///// Setters /////
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome está vazio!");
        }
    }
}
