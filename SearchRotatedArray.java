// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Use binary search. Every time you find mid, then one half is sorted and other is not.


public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]) {
                //left sorted array
                if(nums[low] <= target && target <= nums[mid]) {    //if target is in left part
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if(nums[mid] <= nums[high]) {
                //right sorted array
                if(nums[mid] <= target && target <= nums[high]) {   //if target is in left part
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
        int[] nums = {4,5,6,7,0,1,2};

        int target = 0;
        int result = searchRotatedArray.search(nums, target);
        System.out.println("Index of " + target + " is " + result);

        target = 3;
        result = searchRotatedArray.search(nums, target);
        System.out.println("Index of " + target + " is " + result);
   }
}