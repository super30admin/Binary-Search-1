// Verify if the array is left sorted or right sorted and perform the binary search on the target

// Time Complexity - O(logn)
// Space Complexity - O(1)

class Solution {
    public int search(int[] nums, int target) {

        //Validate inputs
        if(nums == null && nums.length == 0 ){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        while(low <= high)
        {
            int mid = low+(high - low)/2;

            if (nums[mid] == target){
                return mid;
            }

            // Left sorted array
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] >= target)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {   // Right sorted array
                if (nums[mid] <= target && nums[high] >= target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }