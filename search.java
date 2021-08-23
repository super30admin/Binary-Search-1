//Time=O(log(n)) // classic bin search with extra conditions
//Space=O(1)
class Solution {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) 
          return mid;
      else if (nums[mid] >= nums[l]) {
        if (target >= nums[l] && target < nums[mid]) 
            r = mid - 1;
        else 
            l = mid + 1;
      }
      else {
        if (target <= nums[r] && target > nums[mid]) 
            l = mid + 1;
        else 
            r = mid - 1;
      }
    }
    return -1;
  }
}
