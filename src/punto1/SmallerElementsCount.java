package punto1;

import java.util.*;

public class SmallerElementsCount {

    // Clase auxiliar para llevar el índice original de cada elemento
    private static class Element {
        int value;
        int originalIndex;

        Element(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int n = nums.length;
        Element[] elements = new Element[n];
        Integer[] counts = new Integer[n];
        Arrays.fill(counts, 0);

        // Inicializamos el arreglo de elementos con sus índices originales
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i);
        }

        // Llamamos a la función mergeSort modificada
        mergeSort(elements, counts, 0, n - 1);

        return Arrays.asList(counts);
    }

    private static void mergeSort(Element[] elements, Integer[] counts, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSort(elements, counts, start, mid);
        mergeSort(elements, counts, mid + 1, end);

        merge(elements, counts, start, mid, end);
    }

    private static void merge(Element[] elements, Integer[] counts, int start, int mid, int end) {
        Element[] merged = new Element[end - start + 1];
        int left = start;
        int right = mid + 1;
        int mergedIndex = 0;
        int rightCount = 0; // Contador de elementos menores desde la derecha

        while (left <= mid && right <= end) {
            if (elements[right].value < elements[left].value) {
                rightCount++;
                merged[mergedIndex++] = elements[right++];
            } else {
                counts[elements[left].originalIndex] += rightCount;
                merged[mergedIndex++] = elements[left++];
            }
        }

        // Procesar los elementos restantes del lado izquierdo
        while (left <= mid) {
            counts[elements[left].originalIndex] += rightCount;
            merged[mergedIndex++] = elements[left++];
        }

        // Procesar los elementos restantes del lado derecho
        while (right <= end) {
            merged[mergedIndex++] = elements[right++];
        }

        // Copiar el arreglo ordenado de vuelta al original
        System.arraycopy(merged, 0, elements, start, merged.length);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1, 3};
        List<Integer> result = countSmaller(nums);
        System.out.println(result); // Output: [3, 1, 2, 0, 0]
    }
}