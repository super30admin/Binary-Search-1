// Problem: Search in Rotated Sorted Array

// The approach uses a modified Binary Search.
// Even in a rotated sorted array, at least one half (left or right) of any 'mid' index will be sorted.
// 1. Identify which half is sorted.
// 2. Check if the target lies within the boundaries of that sorted half.
// 3. Move the search range accordingly.
//
// Time Complexity: O(log n) - We divide the search space by half in each step.
// Space Complexity: O(1) - We use only a few pointers.
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){   // if array is empty, we don't need to check if target is present in it or not
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2; // to avoid integer overflow

            if(nums[mid] == target){     // check for target at mid
                return mid;
            }
            // if array is left sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){ // check if target is in sorted range or not
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                // array is right sorted
                if(nums[mid] < target && nums[high] >= target){ // check if target is in sorted range or not
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

        }
        // we didnt find the target
        return -1;

    }
}