// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) //If there is no array at all(null pointer) or if it is declared, but length is zero return false
            return -1;
        int low = 0, high = nums.length - 1; //low will point to the first element and high will point to the last one
        while(low <= high){ //Iterate as long as low does not become greater than high
            int mid = low + (high - low) / 2; //Calculated this way to avoid integer overflow
            if(nums[mid] == target) //If the element at mid position is the target
                return mid;
            if(nums[low] <= nums[mid]){ //Check if the left side of mid is sorted
                if(nums[low] <= target && nums[mid] > target){ 
                    high = mid - 1; //Shift high to the left of mid if target lies between low(inclusive) and mid
                } else {
                    low = mid + 1; //Shift low to the right of mid otherwise
                }
            } else { //Right side of mid will be sorted if left is not
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1; //Shift low to the right of mid if the target lies between mid and high(inclusive)
                } else {
                    high = mid -1; //Shift high to the left otherwise
                }
            }
        }
        return -1; //Target not found
    }
}