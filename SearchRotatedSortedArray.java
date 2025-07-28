// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// - I used a modified binary search approach to account for rotation in the sorted array. 
// - At each step, I determine whether the left or right half is sorted and use that information to decide where to search next.
// - The recursion continues until the target is found or the search space is exhausted.

public class SearchRotatedSortedArray {
    public int searchHelper(int[] nums, int target, int left, int right){
        if(left > right){
            return -1;
        }

        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] >= nums[left]){
            // left half is sorted

            if(nums[left] <= target && target <= nums[mid]){
                // target is in left half
                return searchHelper(nums, target, left, mid - 1);
            }else{
                // target is in right half
                return searchHelper(nums, target, mid + 1, right);
            }
        }else{
            // right half is sorted

            if(nums[mid] <= target && target <= nums[right]){
                // target is in right half
                return searchHelper(nums, target, mid + 1, right);
            }else{
                // target is in left half
                return searchHelper(nums, target, left, mid - 1);
            }
        }
    }

    public int search(int[] nums, int target){
        int n = nums.length;
        return searchHelper(nums, target, 0, n - 1);
    }
}
