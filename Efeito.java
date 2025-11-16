public enum Efeito {
    CURA(25),           // Cura 25 Pontos de Vida
    SUPERCURA(50),    // Cura 50 Pontos de Vida
    BUFF_ATAQUE(3),   // Aumenta Ataque em 3
    BUFF_DEFESA(5),   // Aumenta Defesa em 5
    CURA_SINAL(4);   // Restaura 4 Sinais (para o Bruxo)
    

    private int valor;

    Efeito(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return this.valor;
    }
}