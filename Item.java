import java.util.Objects;

public class Item implements Comparable<Item> {

    private String nome;
    private String descricao;
    private Efeito efeito;
    private int quantidade;

    public Item(String nome, String descricao, Efeito efeito, int quantidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        if (efeito == null) {
            throw new IllegalArgumentException("O efeito não pode ser nulo.");
        }
        
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
        
        this.setQuantidade(quantidade);
    }

    // --- Construtor Copia ---
    public Item(Item outroItem) {
        this.nome = outroItem.nome;
        this.descricao = outroItem.descricao;
        this.efeito = outroItem.efeito;
        this.quantidade = outroItem.quantidade;
    }

    // --- Getters e Setters ---
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setter para quantidade
    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", efeito=" + efeito +
                ", quantidade=" + quantidade +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;    
        // Compara nome e efeito
        return Objects.equals(this.nome, item.nome) &&
               this.efeito == item.efeito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, efeito);
    }

    @Override
    public int compareTo(Item outroItem) {
        int comparacaoPorNome = this.nome.compareTo(outroItem.nome);
        if (comparacaoPorNome != 0) {
            return comparacaoPorNome;
        }
        return this.efeito.compareTo(outroItem.efeito);
    }
}