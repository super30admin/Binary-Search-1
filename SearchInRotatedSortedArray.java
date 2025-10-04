/**
 *  Time Complexity: O(log n) means how many times you divide n until you reach 1. for eg. n = 20, we divide (20/2) 4 times to reach 1.
 *                    hence log 20 = ~4
 * 
 *  Space Complexity: O(1) as we don't take any linear space
 */

/**
 * In rotated sorted array, at least one side is always sorted. 
 * We find the sorted side and check if our element lies in that range
 * if yes, we apply binary search 
 * if no, we reject that side and do binary search on other side
 */

class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + (high - low) / 2);

            if(nums[mid] == target){
                return mid;
            }else if(nums[low] <= nums[mid]) { // check if left side is sorted
                if(nums[low] <= target && nums[mid] >= target){ // target lies in sorted left range
                    high = mid - 1; // reduce search space from right
                }else{
                    low = mid + 1; // reduce search space from left as target is not in range
                }
            }else{
                if(nums[mid] <= target && nums[high] >= target){ // target lies in right sorted range
                    low = mid + 1; // reduce search space from left
                }else{
                    high = mid - 1; // reduce search space from right
                }
            }
        }

        return -1;
    }
}