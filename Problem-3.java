// Search in Infinite sorted array

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

public class solution {
    public static int binarySearch(int[] arr, int target) {
        if(arr.length==0) return -1;
        int low = 0;
        int high = 1;
        while (arr[high] < target) { //Find the index of high until the target becomes smaller han high
            low = high;
            high = 2 * high;
        }
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}