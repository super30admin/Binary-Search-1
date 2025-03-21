/* Time complexity: O(log(m*n))
 * Space complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){ // left sorted
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{ //right sorted
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}