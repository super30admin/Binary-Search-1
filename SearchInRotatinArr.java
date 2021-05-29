// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No, but initially i solved this problem with the time complexity 2logn

class Solution {

    public int search(int[] nums, int target) {
      if(nums.length == 0 ||nums ==null){
        return -1;
      }
      //binary search to find the element
      int low = 0;
      int high = nums.length-1;
      while(low<=high){
        int mid = low+(high-low)/2;
        if(nums[mid] == target) {
          return mid;
        }
        else if(nums[low] <= nums[mid]) { //left side of the array is sorted
          //check the target is in the left side 
          if(nums[low] <= target && nums[mid] > target) {
            high = mid-1;
          } else { //target is in right side
            low = mid + 1;
          }
          
        } else {//right sorted part
           if(nums[mid]< target && nums[high] >=target) {
              low = mid +1;
           } else  {
             high = mid-1;
           }
        }
      }
      return -1;
      
    }
}