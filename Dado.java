import java.util.Random;
public class Dado {
    private int numerodeLados;
    private Random random;

    public Dado(int Lados) {
        this.random = new Random();
        this.numerodeLados = Lados;
    }

    public int rolar() {
    int numeroAleatorio = this.random.nextInt(this.numerodeLados); 
    return numeroAleatorio + 1; 
    }

}
