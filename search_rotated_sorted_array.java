// In this problem we are trying to find the index of an element in a rotated sorted array
// We only search in one particular half first checking if that half is sorted and then checking if target might lie in that half. 
// Otherwise, by default it would lie in other half. 
// Time complexity: O(log n) <-- as we are only searching in half array every time
// Space Complexity: O(1) <-- as we only declare variables and not use any additional storage

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else{
                // Check if left side is sorted
                if(nums[mid] >= nums[low]){
                    // Check if target can lie on the left side
                    if (nums[low] <= target && nums[mid] > target){
                        high = mid - 1;
                    }
                    // Else target has to be on the right
                    else{
                        low = mid + 1;
                    }
                    
                }
                // Right side is sorted 
                else {
                    // Check if target can lie on the right
                    if (nums[high] >= target && nums[mid] < target){
                        low = mid + 1;
                    }
                    // Target has to lie on the left
                    else{
                        high = mid - 1;
                    }

                }
            }
        }
        return -1;
    }
}
