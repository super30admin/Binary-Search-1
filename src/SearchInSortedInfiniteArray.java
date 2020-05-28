// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not leetcode problem
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class SearchInSortedInfiniteArray {

    public int search(int[] nums, int key) {
        int low = 0;
        int high = 1;

        /*
         * find bounds by increasing high twice
         * not using the length function for bounds check assuming
         * array is an infinite array
         */
        while(nums[high] <= key) {
            if (key == nums[high]) {
                return high;
            } else
            {
                low = high;
                high = high * 2;
            }
        }
        return binarySearch(nums, low, high, key);
    }

    //iterative binary search
    public int binarySearch(int[] nums, int low, int high, int key) {

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == key) {
                return mid;
            } else {
                if(key > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}

