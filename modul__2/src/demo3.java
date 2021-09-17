public class demo3 {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,20,21,24,35,36,38};
        System.out.println(binarySearch(arr,0,9,36));
    }
    static public  int binarySearch(int[] array, int left, int right, int value) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if(array[middle] == value){
                return middle;
            }
            if(value > array[middle]){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
