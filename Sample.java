// Time Complexity : O(log n), n - number of values in array.

// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  //time consuming, and hard time thinking about the solution.

// Your code here along with comments explaining your approach
  //1. do modified binary search on array.
  //2. chk if num[mid] > num[strt],
  //   2.a YES, we know arry sorted from strt to mid.
  //      if target > nums[strt] do normal binary search operation
  //      if target < nums[strt] definately falls after mid.
  //   2.b NO, we know arry sorted from mid to end.
  //      if target < nums[end] do normal binary search operation
  //      if target > nums[end] definately falls before mid.

class Solution {
  public int search(int[] nums, int target) {
      int strt = 0 ;
      int end = nums.length -1;

      while(strt <= end){
          int mid = strt+((end-strt)/2);
          //found return
          if(nums[mid] == target)
              return mid;


          if(nums[mid] >= nums[strt]){
              //no roatation in this array from strt to mid.
              //mid is greater than strt, any val < strt, lies right to mid.
              if(target >= nums[strt]){
                  if(target < nums[mid])
                      end = mid -1;
                  else
                      strt = mid+1;
              }
              else{
                  strt = mid+1;
              }
          }
          else{
              //roatation in this array from strt to mid.
              //mid is less than strt, any val > end, lies left to mid.
              if(target <= nums[end]){
                  if(target < nums[mid])
                      end = mid -1;
                  else
                      strt = mid+1;
              }
              else{
                  end = mid-1;
              }
          }
      }
      return -1;
  }
}
