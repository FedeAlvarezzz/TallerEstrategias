package punto3;

import java.util.HashMap;

public class LucasMemorizacion {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int lucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int value = lucas(n - 1) + lucas(n - 2);
        memo.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(lucas(i) + " ");
        }
    }
}

