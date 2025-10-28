import java.util.Random;
public class Dado {
    private int numerodeLados;
    private Random random;

    public Dado(int Lados) {
        this.random = new Random();
        this.numerodeLados = Lados;
    }
    public int rolar() {
        int numeroAleatorio = this.random.nextInt(20); //Gera numero aleatorio de 0 até 19
        return numeroAleatorio + 1; // 0 vira 1 e 19 vira 20
    }
}
