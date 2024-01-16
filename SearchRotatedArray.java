// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class SearchRotatedArray {
    public int search(int[] nums, int target) {
      int l=0;
      int h = nums.length-1;

      while(l <= h){
        int m = l + (h-l)/2;
        if(nums[m]== target) return m;

        // left sorted
        if(nums[m] >= nums[l]){
          // targets in sorted left side?
          if(nums[m] > target && target >= nums[l]){
            h=m-1;
          }
          else{
            l=m+1;
          }
        }
        //right sorted
        else{
          // targets in sorted rt side?
          if(nums[m] < target && target <= nums[h]){
            l=m+1;
          }
          else{
            h=m-1;
          }

        }
      }
      return -1;
    }
  }
