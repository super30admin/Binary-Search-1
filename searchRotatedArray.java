//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can make use of binary search to search for the target as the elements are in sorted order in the matix


class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
       int hi = nums.length - 1;
       while(lo <= hi){
           int mid = lo + (hi - lo)/2;
           if(nums[mid] == target) //if nums[mid] is equal to target return mid
               return mid;
           else if(nums[mid] >= nums[lo] ){ // else if nums[mid] is greater than nums[lo]
                   if(target >= nums[lo] && target < nums[mid]) // and if target is less than nums[lo] and less than nums[mid] then target is in the first half of the array
                       hi = mid - 1;
                   else
                       lo = mid + 1; //else target is between second half of the array
           }
           else{
               if(target <= nums[hi]  && target > nums[mid]) //if target is less than nums[hi] and greater than nums[mid] then target is in the second half of the array
                   lo = mid + 1;
               else
                   hi = mid - 1; //else target is in the 
           }
       }
       return -1;
    }
}
