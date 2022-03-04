// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was not able to come up with O(log(n)) solution 
//Note: I am implementing it after class as I was not able to come up with O(log(n)) solution.  
// https://leetcode.com/problems/search-in-rotated-sorted-array/


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1; //handling edge case
        int l = 0; 
        int h = nums.length - 1;
        
        while(l<=h) { 
            int mid = l + (h-l)/2; // to avoid overflow
            if(nums[mid] == target) return mid; //element found
            else if(nums[l]<=nums[mid]) { //left sorted
                if(nums[l] <= target && nums[mid] > target) { // target lies in the sorted part
                    h = mid-1;
                } else { // target is in unsorted part
                    l = mid + 1;
                }
            } else { //right sorted
                if(nums[mid] < target && nums[h] >= target) { // target lies in the sorted part
                    l = mid + 1;
                } else { // target is in unsorted part
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}