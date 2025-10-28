import java.util.*;

public class Inventario {
    private Map<String, Item> itens;
    
    public Inventario() {
        this.itens = new HashMap<>();
    }
    
    public Inventario(Inventario outro) {
        this.itens = new HashMap<>();
        for (Map.Entry<String, Item> entry : outro.itens.entrySet()) {
            this.itens.put(entry.getKey(), new Item(entry.getValue()));
        }
    }
    
    private String gerarChave(Item item) {
        return item.getNome().toLowerCase() + "_" + item.getEfeito().name();
    }
    
    private String gerarChave(String nome, Efeito efeito) {
        return nome.toLowerCase() + "_" + efeito.name();
    }
    
    public void adicionar(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo");
        }
        
        String chave = gerarChave(item);
        
        if (itens.containsKey(chave)) {
            Item itemExistente = itens.get(chave);
            itemExistente.setQuantidade(itemExistente.getQuantidade() + item.getQuantidade());
        } else {
            itens.put(chave, new Item(item));
        }
    }
    
    public boolean remover(String nome, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        
        for (Map.Entry<String, Item> entry : itens.entrySet()) {
            Item item = entry.getValue();
            if (item.getNome().equalsIgnoreCase(nome)) {
                if (item.getQuantidade() >= quantidade) {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    
                    if (item.getQuantidade() == 0) {
                        itens.remove(entry.getKey());
                    }
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    public boolean remover(String nome, Efeito efeito, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        
        String chave = gerarChave(nome, efeito);
        Item item = itens.get(chave);
        
        if (item != null && item.getQuantidade() >= quantidade) {
            item.setQuantidade(item.getQuantidade() - quantidade);
            
            if (item.getQuantidade() == 0) {
                itens.remove(chave);
            }
            return true;
        }
        return false;
    }
    
    public List<Item> listarOrdenado() {
        List<Item> lista = new ArrayList<>(itens.values());
        Collections.sort(lista);
        return lista;
    }
    
    public Item getItem(String nome, Efeito efeito) {
        String chave = gerarChave(nome, efeito);
        Item item = itens.get(chave);
        return item != null ? new Item(item) : null;
    }
    
    public List<Item> getItensPorNome(String nome) {
        List<Item> resultado = new ArrayList<>();
        for (Item item : itens.values()) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                resultado.add(new Item(item));
            }
        }
        return resultado;
    }
    
    public List<Item> getItensPorEfeito(Efeito efeito) {
        List<Item> resultado = new ArrayList<>();
        for (Item item : itens.values()) {
            if (item.getEfeito() == efeito) {
                resultado.add(new Item(item));
            }
        }
        Collections.sort(resultado);
        return resultado;
    }
    
    public boolean contem(String nome, Efeito efeito) {
        return itens.containsKey(gerarChave(nome, efeito));
    }
    
    public boolean contemQuantidade(String nome, Efeito efeito, int quantidade) {
        String chave = gerarChave(nome, efeito);
        Item item = itens.get(chave);
        return item != null && item.getQuantidade() >= quantidade;
    }
    
    public int getQuantidadeTotalItens() {
        int total = 0;
        for (Item item : itens.values()) {
            total += item.getQuantidade();
        }
        return total;
    }
    
    public int getNumeroTiposItens() {
        return itens.size();
    }
    
    public boolean estaVazio() {
        return itens.isEmpty();
    }
    
    public void limpar() {
        itens.clear();
    }
    
    public void transferirItens(Inventario destino, List<Item> itensParaTransferir) {
        if (destino == null) {
            throw new IllegalArgumentException("Inventário destino não pode ser nulo");
        }
        
        for (Item item : itensParaTransferir) {
            if (this.remover(item.getNome(), item.getEfeito(), item.getQuantidade())) {
                destino.adicionar(item);
            }
        }
    }
    
    public Inventario clone() {
        return new Inventario(this);
    }
    
    @Override
    public String toString() {
        if (itens.isEmpty()) {
            return "Inventário vazio";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== INVENTÁRIO ===\n");
        
        List<Item> ordenados = listarOrdenado();
        for (int i = 0; i < ordenados.size(); i++) {
            Item item = ordenados.get(i);
            sb.append(String.format("%d. %s (%s) - %d unidades\n", 
                i + 1, item.getNome(), item.getEfeito(), item.getQuantidade()));
        }
        
        sb.append(String.format("\nTotal: %d itens (%d tipos diferentes)", 
            getQuantidadeTotalItens(), getNumeroTiposItens()));
        
        return sb.toString();
    }
    
    public String toStringResumido() {
        if (itens.isEmpty()) {
            return "Vazio";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Item> ordenados = listarOrdenado();
        
        for (int i = 0; i < ordenados.size(); i++) {
            if (i > 0) sb.append(", ");
            Item item = ordenados.get(i);
            sb.append(String.format("%s(%d)", item.getNome(), item.getQuantidade()));
        }
        
        return sb.toString();
    }
}
