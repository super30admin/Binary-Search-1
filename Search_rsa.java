// Time Complexity : O(logn) since we're using binary search approach
// Space Complexity : O(1) we're not using any extra auxilary space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
* BruteForce approach - Apply linear search - O(N)
* Optimized approach - first check if the array is empty or null, returning -1 if true.
* Then, we use a while loop to iteratively narrow down the search range by comparing the target value with elements at mid, left, and right indices,
* adjusting the left and right pointers accordingly until the target is found or the search range is exhausted.
*/

public class Search_rsa {

    public static int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 1;
            if (nums[mid] == target) {
                return mid;
            }
            // left sorted
            else if(nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right  = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right sorted
            else {
                if (nums[mid] <= target && nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 100));
    }
}
