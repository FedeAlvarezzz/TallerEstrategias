package punto2.Diapositiva25;

import java.util.*;

public class FibraOptica {

    public static void kruskal(int numMunicipios, List<Nodo> nodos) {
        Collections.sort(nodos);
        BuscarUnion uf = new BuscarUnion(numMunicipios);
        int costoTotal = 0;
        List<Nodo> mst = new ArrayList<>();

        for (Nodo a : nodos) {
            if (uf.unir(a.origen, a.destino)) {
                mst.add(a);
                costoTotal += a.costo;
            }
        }

        System.out.println("Aristas seleccionadas para la red:");
        for (Nodo a : mst)
            System.out.println(a);
        System.out.println("Costo total de la red: " + costoTotal);
    }

    public static void main(String[] args) {
        int numMunicipios = 5;
        List<Nodo> nodos = Arrays.asList(
                new Nodo(0, 1, 10),
                new Nodo(0, 2, 5),
                new Nodo(1, 2, 2),
                new Nodo(1, 3, 1),
                new Nodo(2, 3, 9),
                new Nodo(3, 4, 4)
        );

        kruskal(numMunicipios, nodos);
    }
}
