// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length -1;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;
            if (nums[mid] == target) return mid;

            //check which side array is sorted
            if (nums[low] <= nums[mid]){ // left is sorted
                if (nums[mid] > target && nums[low] <= target){
                    high = mid -1;
                } else {
                    low = mid+1;
                }
            } else {//right is sorted
                if (nums[mid] < target && nums[high] >= target){
                    low = mid +1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
    

