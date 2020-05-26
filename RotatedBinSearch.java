// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Referred https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) 
            return -1;
        
        int l = 0;
        int r = nums.length-1;
        
        // find the smallest elements index
        while(l < r){
            int midpoint = l + (r - l)/2; //To avoid integer overflow
            if(nums[midpoint] > nums[r]) {
                l = midpoint + 1;
            } else {
                r = midpoint;
            }
        }
        
        int start = l;
        l = 0;
        r = nums.length-1;
        
        if(target >= nums[start] && target <= nums[r]){ //Search between the sorted array from left
            l = start;            
        } else {
            r = start;  //Search from the other side of the array
        }

        //Regular binary search
        while(l <= r){
            int midpoint = l + (r - l) /2;
            if (nums[midpoint] == target){
                return midpoint;
            }else if (nums[midpoint] < target){
                l = midpoint + 1;
            }else {
                r = midpoint - 1;
            }
        }
        return -1;
    }
}