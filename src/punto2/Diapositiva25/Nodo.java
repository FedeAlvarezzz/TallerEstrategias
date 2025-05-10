package punto2.Diapositiva25;

public class Nodo implements Comparable<Nodo> {
    int origen, destino;
    int costo;

    public Nodo(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public int compareTo(Nodo siguiente) {
        return this.costo - siguiente.costo;
    }

    @Override
    public String toString() {
        return String.format("(%d - %d) Costo: %d", origen, destino, costo);
    }
}
