// Time Complexity : O(log n), since we use binary search
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially used '<' instead of '<=' in the sorted half check, which caused incorrect results
//Approach : 
// I used binary search to locate the target in a rotated sorted array.
// At each step, I determined whether the left or right half of the array is sorted.
// Based on which half is sorted and where the target lies, I adjusted the search boundaries accordingly.
class Solution2 {
    //{7,8,9,1,2,3,4,5,6}
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length -1 ;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[start] <= nums[mid]) {  //left part sorted
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1 ;
                } else {
                    start = mid + 1;
                }
            } else { // right part sorted
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,1,2,3,4,5,6}; 
        int target = 1;
        Solution2 sol = new Solution2();
        System.out.println("Serached Output: " + sol.search(nums, target));
    }

//Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4

//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1

//Example 3:
//Input: nums = [1], target = 0
//Output: -1

//Example 4:
//Input: nums = [7,8,9,1,2,3,4,5,6], target = 1
//Output: 3

}