// Time Complexity : The time complexity is O(log(n)) where n is the length of array because for every iteration the search space is divided by half
// Space Complexity : The space complexity is O(1) since no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        if(nums == null || n == 0) return -1;

        int start = 0;
        int end = n-1;

        while(start <= end){

            int mid = (end-start)/2 + start;

            // Return the index if target is found
            if(nums[mid] == target){
                return mid;
            }
            // If left part is sorted
            else if(nums[mid] >= nums[start]) {
                // If target lies in the sorted part, move to the left
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid-1;
                }
                // If target doesnt lie in the sorted part, move to the right
                else{
                    start = mid+1;
                }
            }
            // If right part is sorted
            else{
                // If target lies in the sorted part, move to the right
                if(target <= nums[end] && target > nums[mid]){
                    start = mid+1;
                }
                // If target doesnt lie in the sorted part, move to the left
                else{
                    end = mid-1;
                }
            }

        }

        return -1;

    }
}