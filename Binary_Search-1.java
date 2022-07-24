// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Basic Syntax Error (Solved myself)


// Your code here along with comments explaining your approach
// Basic approach I used was to understand the idea of the problem, the array is sorted at a pivot and also asks me to search an element, I use the basic pattern of solving the sum by using Binary Search and to retain the rule of the Binary Search I will reduce the search by half of increase it by twice


class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length == 0) return  -1;
        int low = 0; int high =nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
                if(nums[mid] == target) return mid;
                else if (nums[low] <= nums[mid]) {
                    if(nums[low] <= target && nums[mid]>target ){
                        high = mid -1;
                    }else{
                        low=mid+1;
                    }
                }     
                else{
                    if(nums[mid]<target && nums[high]>=target){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }
                }
        }
        return -1;
    }
}