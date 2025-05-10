package punto3;

public class MochilaMemorizacion {

    static int[][] memoria;

    public static int mochila(int[] valores, int[] pesos, int capacidad, int n) {

        if (n == 0 || capacidad == 0) {
            return 0;
        }

        if (memoria[n][capacidad] != -1) {
            return memoria[n][capacidad];
        }

        if (pesos[n - 1] > capacidad) {
            memoria[n][capacidad] = mochila(valores, pesos, capacidad, n - 1);
        } else {

            int incluir = valores[n - 1] + mochila(valores, pesos, capacidad - pesos[n - 1], n - 1);
            int excluir = mochila(valores, pesos, capacidad, n - 1);
            memoria[n][capacidad] = Math.max(incluir, excluir);
        }

        return memoria[n][capacidad];
    }

    public static void main(String[] args) {
        int[] valores = {2, 5, 10, 14, 15};
        int[] pesos = {1, 3, 4, 5, 7};
        int capacidad = 8;
        int n = valores.length;

        memoria = new int[n + 1][capacidad + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                memoria[i][j] = -1;
            }
        }

        int resultado = mochila(valores, pesos, capacidad, n);
        System.out.println("Valor máximo en la mochila:  " + resultado);
    }
}
