// in a rotated sorted array, either one half of the array is always sorted. If target is in the sorted part, then use binary search on that part, else eliminate that part and repeat the same procedure on the right part
//Time complexity: O(logn)
class Solution {
    public int search(int[] nums, int target) {
       int low=0;
       int high = nums.length-1;
       while(low <= high) {
           int mid = low + (high - low) / 2;
           if(nums[mid] == target) {
               return mid;
           }
           if(nums[low] <= nums[mid]) {
               if(nums[low] <= target && target < nums[mid]) {
                   high = mid-1;
               }
               else low = mid+1;
           }
           else {
               if(nums[mid] < target && target <= nums[high]) {
                   low = mid+1;
               }
               else high = mid-1;
           }
       }
    return -1;
    }
    
}
