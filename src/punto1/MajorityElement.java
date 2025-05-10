package punto1;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private static int majorityElementRec(int[] nums, int low, int high) {
        // Caso base: si el subarreglo tiene tamaño 1, el único elemento es el candidato
        if (low == high) {
            return nums[low];
        }

        // Dividir el arreglo en dos mitades
        int mid = low + (high - low) / 2;
        int leftMajority = majorityElementRec(nums, low, mid);
        int rightMajority = majorityElementRec(nums, mid + 1, high);

        // Si ambas mitades tienen el mismo candidato, retornarlo
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // Contar cuál de los dos candidatos aparece más en el subarreglo actual
        int leftCount = countInRange(nums, leftMajority, low, high);
        int rightCount = countInRange(nums, rightMajority, low, high);

        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    private static int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);

        // Verificar si el candidato es realmente mayoría
        int count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            System.out.println("El elemento mayoritario es: " + result);
        } else {
            System.out.println("No hay elemento mayoritario: -1");
        }
    }
}
