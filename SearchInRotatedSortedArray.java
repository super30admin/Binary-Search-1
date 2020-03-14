//33.Search in rotated array
// Time Complexity : O(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                return mid;
            } else if (nums[low] <= nums[mid]){ // left array is sorted
                // target lies in left half
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1; 
                } else { // target lies in right half
                    low = mid + 1;
                }
            } else { // right array is sorted
                // target lies in right half
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else { // target lies in left half
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}