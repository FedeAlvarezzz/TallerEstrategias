package punto2.Diapositiva22;

import java.util.*;

public class CambioBilletes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] denominaciones = {100000, 50000, 20000, 10000};
        int[] disponibilidad = {50, 100, 200, 300};

        System.out.print("Ingrese la cantidad de dinero a entregar (múltiplo de 10000): ");
        int monto = scanner.nextInt();

        if (monto % 10000 != 0) {
            System.out.println("El monto debe ser múltiplo de 10000.");
            return;
        }

        int[] entregados = new int[denominaciones.length];

        for (int i = 0; i < denominaciones.length; i++) {
            int billetesNecesarios = monto / denominaciones[i];
            int billetesAUsar = Math.min(billetesNecesarios, disponibilidad[i]);
            entregados[i] = billetesAUsar;
            monto -= billetesAUsar * denominaciones[i];
        }

        if (monto == 0) {
            System.out.println("Billetes entregados:");
            for (int i = 0; i < denominaciones.length; i++) {
                System.out.println("$" + denominaciones[i] + " x " + entregados[i]);
            }
        } else {
            System.out.println("No hay suficientes billetes para entregar el monto solicitado.");
        }
    }
}
