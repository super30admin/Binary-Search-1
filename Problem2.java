// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * First check which part is sorted, is it left-sorted or right-sorted.
 * Based on the result above, check if the target fits in the range i.e.
 * If left sorted, should fit between low and mid. If right sorted, should fit mid and high. Compute further accordingly
 */

public class Problem2 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem2 obj = new Problem2();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(obj.search(nums, target));

        nums = new int[]{6,7,0,1,2,4,5};
        target = 7;
        System.out.println(obj.search(nums, target));

        nums = new int[]{1,2,5,3};
        target = 7;
        System.out.println(obj.search(nums, target));

        nums = new int[]{3,1};
        target = 1;
        System.out.println(obj.search(nums, target));
    }
}