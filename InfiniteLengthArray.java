// Time Complexity - O(N)
// Space Complexity - O(1)

public class InfiniteLengthArray {

    public static boolean infiniteArray(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (arr[end] < target) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        boolean answer = binarySearch(arr, start, end, target);
        return answer;
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        boolean result = infiniteArray(arr, 8);
        System.out.println(result);
    }

}
