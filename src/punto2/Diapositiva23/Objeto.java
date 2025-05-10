package punto2.Diapositiva23;

public class Objeto {
    double peso, valor;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double getDensidad() {
        return valor / peso;
    }

    @Override
    public String toString() {
        return String.format("Peso: %.2f, Valor: %.2f", peso, valor);
    }
}
