// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Separate out the sorted and unsorted part and then get the index buy applying binnay search in each
// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        if( nums == null || nums.length == 0) return -1;
        int low = 0; int high = nums.length - 1;
        while( low <= high ){
            int mid = low + (high - low) / 2;
            if( nums[mid] == target){
                return mid;
            }
            else if( nums[low] <= nums[mid]){ // if left is sorted
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{ // if right is sorted
                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return - 1;
    }
}