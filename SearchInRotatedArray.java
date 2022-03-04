public class SearchInRotatedArray {
  /*
  Once you observe the pattern here, you'll see that one side of the array is sorted while the other is not after finding mid point in the array.

  On the sorted end, you can perforn Binary search if the target lies in between, if not, adjust pointers so that search happens on the 
  other half of your search space.

  2 approaches here:
     * Iterative
     * Recursive
    
     Recursive solution is a little more intuitive than the Iterative, but Recursive solution occupies extra space for the recursion stack.

  
  Time Complexity: O(log(n))
  Space Complexity: O(1)

  Did this code successfully run on Leetcode : Yes
  Any problem you faced while coding this : No 
  */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length-1;
    
    while(left <= right){
        int mid = left + (right - left )/2;
        
        if(nums[mid] == target) return mid;
        else if (nums[mid] < nums[right]){ // Array is right sorted
            if(nums[mid+1] <= target && target <= nums[right]){ // and target lies in between
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else { // Array is left sorted {
            if(nums[left] <= target && target < nums[mid]){ // and target lies in between
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    
    return -1;
  }
}
