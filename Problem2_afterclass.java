// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes(not a problem in leetcode)
// Any problem you faced while coding this : The code runs well when i use the array as specified. However, when I try to use another array which I have commented right now, and search for 35 as target it gives me out of bound exception

// Your code here along with comments explaining your approach: Infinite array means that you cannot find the sixe of the array. Hence I have used 2 pointers low and high, high runs 2 times the loop and low takes the value of high every loop. The taget i found between low and high and then I use binary search in it

public class infinite_array {

    public static int binarySearch(int arr[], int l, int r, int x) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            if (arr[mid] < x) {
                return binarySearch(arr, mid + 1, r, x);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // int[] arr= {2,3,8,9,11,15,18,25,29,35,40,41,49,52,54};
        int[] arr = { 3, 5, 7, 10, 11, 13, 14, 15, 17, 19 };
        int low = 0;
        int high = 1;
        int target = 35;

        while (arr[high] <= target) {
            low = high;
            high = high * 2;
        }

        int result = binarySearch(arr, low, high, target);
        System.out.println(result);

    }

}