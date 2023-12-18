// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;

            else if(nums[low] <= nums[mid])
            {
                //This means left part of the array is in sorted form.

                if(target >= nums[low] && target <= nums[mid])
                {
                    //target element is in this range.
                    high = mid - 1;
                }
                else
                {
                    //target element is not present in the left sorted array
                    low = mid + 1;
                }
            }
            else if(target >= nums[mid] && target <= nums[high])
            {
                //right part of the array is sorted.
                low = mid + 1;
            }
            else
            {
                //right part of the array is sorted but the element is present in the
                // left array which is unsorted
                high = mid - 1;
            }
        }

        return -1;
    }  
}