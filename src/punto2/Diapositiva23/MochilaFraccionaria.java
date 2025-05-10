package punto2.Diapositiva23;

import java.util.*;

public class MochilaFraccionaria{

    public static double resolver(List<Objeto> objetos, double capacidad, Comparator<Objeto> heuristica) {
        objetos.sort(heuristica.reversed());
        double pesoTotal = 0, valorTotal = 0;

        for (Objeto obj : objetos) {
            if (pesoTotal + obj.peso <= capacidad) {
                pesoTotal += obj.peso;
                valorTotal += obj.valor;
                System.out.println("Agregado completo: " + obj);
            } else {
                double restante = capacidad - pesoTotal;
                valorTotal += obj.getDensidad() * restante;
                pesoTotal = capacidad;
                System.out.printf("Agregado fraccional: Peso %.2f, Valor %.2f\n", restante, obj.getDensidad() * restante);
                break;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        List<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto(10, 60));
        objetos.add(new Objeto(20, 100));
        objetos.add(new Objeto(30, 120));

        double capacidad = 50;

        System.out.println("1️⃣ Heurística por mayor valor:");
        System.out.printf("Valor total: %.2f\n\n", resolver(new ArrayList<>(objetos), capacidad,
                Comparator.comparingDouble(o -> o.valor)));

        System.out.println("2️⃣ Heurística por menor peso:");
        System.out.printf("Valor total: %.2f\n\n", resolver(new ArrayList<>(objetos), capacidad,
                Comparator.comparingDouble(o -> o.peso)));

        System.out.println("3️⃣ Heurística por mayor densidad valor/peso:");
        System.out.printf("Valor total: %.2f\n", resolver(new ArrayList<>(objetos), capacidad,
                Comparator.comparingDouble(Objeto::getDensidad)));
    }
}
