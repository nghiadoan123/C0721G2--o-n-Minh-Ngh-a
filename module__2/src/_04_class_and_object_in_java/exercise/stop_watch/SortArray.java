package _04_class_and_object_in_java.exercise.stop_watch;

public class SortArray {
    public SortArray() {
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void selectionSort(int arr[], int n) {
        int i, j, minIdx;

        // One by one move boundary of unsorted subarray
        for (i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            minIdx = i;
            for (j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;

            // Swap the found minimum element with the first element
            swap(arr[minIdx], arr[i]);
        }
    }

    /* Function to print an array */
    void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }
    }
}
