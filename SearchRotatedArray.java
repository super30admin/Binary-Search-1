// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            // if target is found in the mid element return true
            if(nums[mid] == target) return mid;
            
            // Binary Search and check if left array is sorted, 
            // if found the range iterate through the left array
            else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target)
                    right = mid-1;
                else left = mid+1;
            }
            
            // Binary Search and check if the right array is sorted, 
            // if found the range iterate through the right array to find the target
            else{
                if(nums[right] >= target && nums[mid] < target)
                    left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
}
