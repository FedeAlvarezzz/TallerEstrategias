package punto3;

public class LucasTabulacion {
    public static int lucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        int[] lucas = new int[n + 1];
        lucas[0] = 2;
        lucas[1] = 1;

        for (int i = 2; i <= n; i++) {
            lucas[i] = lucas[i - 1] + lucas[i - 2];
        }

        return lucas[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(lucas(i) + " ");
        }
    }
}

