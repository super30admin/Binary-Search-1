/**
 * SortedArrayInfinite
 */
public class SortedArrayInfinite {

    int sortArray(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (start <= end) {
           
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            end = end * 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -10, -7, -2, 0, 1, 3, 4, 5, 6, 8 };
        int target = 5;
        SortedArrayInfinite st = new SortedArrayInfinite();
        System.out.println(st.sortArray(arr, target));
    }

}