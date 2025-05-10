package punto2.Diapositiva22;

import java.util.*;

public class CambioBilletes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] denominaciones = {100000, 50000, 20000, 10000};
        long[] disponibilidad = {50, 100, 200, 300};

        System.out.print("Ingrese la cantidad de dinero a entregar (múltiplo de 10000): ");
        long monto = scanner.nextLong();

        if (monto % 10000 != 0) {
            System.out.println("El monto debe ser múltiplo de 10000.");
            return;
        }

        long[] entregados = new long[denominaciones.length];

        for (long i = 0; i < denominaciones.length; i++) {
            long billetesNecesarios = monto / denominaciones[(int) i];
            long billetesAUsar = Math.min(billetesNecesarios, disponibilidad[(int) i]);
            entregados[(int) i] = billetesAUsar;
            monto -= billetesAUsar * denominaciones[(int) i];
        }

        if (monto == 0) {
            System.out.println("Billetes entregados:");
            for (long i = 0; i < denominaciones.length; i++) {
                System.out.println("$" + denominaciones[(int) i] + " x " + entregados[(int) i]);
            }
        } else {
            System.out.println("No hay suficientes billetes para entregar el monto solicitado.");
        }
    }
}
