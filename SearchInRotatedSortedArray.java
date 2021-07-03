/*
    Time Complexity: O(logN)
    Space Complexity: O(1)
    LeetCode: Y (https://leetcode.com/problems/search-in-rotated-sorted-array/)
    Approach: Use the binary search to solve this problem. 
    The reason why binary search works for this problem is 
        if the array is divided into two sub-arrays then at least one of the subarrays will be in increasing order
        
    Modify the binary search to determine which side(left or right) of the mid the target is in  
*/


class Solution {
    public int search(int[] nums, int target) {
        /* Lower and upper bound of binary search */
        int low = 0, high = nums.length - 1;
        
        /* Search for target while there exists a valid range to search the target */ 
        while(low <= high) {
            /* Calculate mid */
            int mid = low + (high - low)/2;
            
            /* If the target number is found */
            if(nums[mid] == target) {
                return mid;
            }
            /* If the left sub-array is sorted */
            else if(nums[low] <= nums[mid]) {
                /* If the left sub-array is sorted and target is in the left sub-array then discard the right sub-array */
                if(target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                }
                /* If the target does not exist in the sorted left sub-array then discard the left sub-array */
                else {
                    low = mid + 1;
                }
            }
            /* If the right sub-array is sorted */
            else if(nums[mid] <= nums[high]) {
                /* If the right sub-array is sorted and target is in the right sub-array then discard the left-subarray */
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                /* If the target does not exist in the sorted right sub-array then discard the right sub-array */
                else {
                    high = mid - 1;
                }
            }   
        }
        return -1;
    }
}
