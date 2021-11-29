package _03_array_and_method.practice;

public class FindMinimumUseMethod {
    public static int minValue(int[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {22, 12, 7, 8, 4, 1, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index] + " at index: " + index);
    }
}
