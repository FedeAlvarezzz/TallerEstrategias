package punto2.Diapositiva25;

public class BuscarUnion {
    int[] padre, rango;

    public BuscarUnion(int n) {
        padre = new int[n];
        rango = new int[n];
        for (int i = 0; i < n; i++) padre[i] = i;
    }

    public int encontrar(int x) {
        if (padre[x] != x)
            padre[x] = encontrar(padre[x]);
        return padre[x];
    }

    public boolean unir(int x, int y) {
        int raizX = encontrar(x), raizY = encontrar(y);
        if (raizX == raizY) return false;
        if (rango[raizX] < rango[raizY]) {
            padre[raizX] = raizY;
        } else if (rango[raizX] > rango[raizY]) {
            padre[raizY] = raizX;
        } else {
            padre[raizY] = raizX;
            rango[raizX]++;
        }
        return true;
    }
}
