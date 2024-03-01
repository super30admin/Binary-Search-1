/**

  Thought Process & Pseudo Code:

  Since, the array is rotated sorted array, it might be left sorted (All the elements from l to mid are sorted) 
  or right sorted (All the elements from mid to h are sorted).
  If the target lies in left sorted, h=mid-1 else l=mid+1
  If the target lies in right sorted , l=mid+1 else h=mid-1

  TC -> O(logN) where N is the length of the array
  SC -> O(1)
  
**/

public class Solution{

  public int search(int[] nums, int target){

    if(nums.length == 0) return -1;
    int l = 0, h = nums.length -1;

    // Start Binary Search
    while(l <= h){
      int mid = l + (h-l) / 2;
      if(nums[mid] == target) return mid;

      // Check if array is left sorted?
      if(nums[mid] >= nums[l]){ // nums[left to mid] are sorted
        if(nums[l] <= target && target < nums[mid]) // Check if target is in the left sorted array?
          h = mid - 1;
        else l = mid + 1;
      }
      // Check if array is right sorted?
      else if(nums[mid] <= nums[h]){
        if( nums[h] >= target && target > nums[mid]) //// Check if target is in the right sorted array?
          l = mid + 1;
        else h = mid - 1;
      }
    }
    return -1;
  }
}
