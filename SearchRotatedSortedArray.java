// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        //base case
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            //if the target lies in the middle element, return target
            if(target == nums[mid]){
                return mid;
            }
            //to find the sorted part of the array
            //first part is sorted
            else if(nums[low] <= nums[mid]){
                //check if the element lies in the sorted range
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                } //else change the low to check the other half
                else {
                    low = mid+1;
                }
            } //second part is sorted
            else {
                //check if the element lies in the sorted range
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                } //else change the high to check the other half
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}