package Sort_2;

import java.util.Arrays;

public class quickSort {
    public static void quickSort(int[] array) {
        //初始情况下，快速排序的区间[0, array.length - 1]
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            return;//一个元素或者没有元素
        }

        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index, right);
    }

    private static int partition(int[] array, int left, int right) {
        //选择最后一个元素为基准值
        int baseIndex = right;
        int baseValue = array[baseIndex];

        while(left < right) {
            while(left < right && array[left] <= baseValue) {
                left++;
            }
            while(left < right && array[right] >= baseValue) {
                right--;
            }
            swap(array, left, right);
        }
        swap(array, left, baseIndex);
        return left;
    }

    private static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
