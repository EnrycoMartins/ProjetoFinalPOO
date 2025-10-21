public class Item {
    private String nome;
    private String descricao;
    private Efeito efeito;
    private int qtd;

    public enum Efeito{
        CURA,
        BUFF_ATQ,
        BUFF_DEF,
        BUFF_MAN,
        BUFF_DPS
    }

    public Item(String nome, String descricao, Efeito efeito, int qtd ){
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
        this.qtd = qtd;
    }
}