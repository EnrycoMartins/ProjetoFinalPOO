public enum Efeito {
    CURA(25),           // Cura 25 Pontos de Vida
    BUFF_ATAQUE(5),   // Aumenta Ataque em 5
    BUFF_DEFESA(5),   // Aumenta Defesa em 5
    CURA_SINAL(2),    // Restaura 2 Sinais (para o Bruxo)
    DANO(-10),          // Causa 10 de dano (ex: veneno)
    OUTRO(0);           // Efeito nulo ou de-logica-custom

    // --- Atributo ---
    private int valor;

    // --- Construtor ---
    Efeito(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return this.valor;
    }
}