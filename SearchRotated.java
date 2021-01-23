// Time complexity - same as Binary Search - O(log n)
// Works on leet code

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        // Start Binary Search
        while(low <= high){
            int mid  = low + (high - low)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            // Check if left is sorted
            else if(nums[low] <= nums[mid]){
                // Start Binary Search within this half
                if(nums[mid] > target && nums[low] <= target){
                    // Move left
                    high = mid - 1;
                }
                else{
                    // Move right
                    low = mid + 1;
                }
            }
            else{
                // Start Binary Search in this half
                if(nums[mid] < target && nums[high] >= target ){
                    // Move right
                    low = mid + 1;
                }
                else{
                    // Move left
                    high = mid - 1;
                }
            }
        }
        // If nothing is found
        return - 1;
    }
}
