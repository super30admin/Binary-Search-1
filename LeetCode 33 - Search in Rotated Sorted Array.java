// Time Complexity: Since we use binary search methods here, 
// so the time complexity will be O(logn).
/* --------------------------------------------------------*/
// Space Complexity: the space complexity will be O(1).

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else{
                // check whether left sorted
                if(nums[mid] >= nums[low]){
                    // check which interval the target locates.
                    if(nums[low] <= target && nums[mid] > target){
                        high = mid -1;
                    }else{
                        low = mid + 1;
                    }
                }
                // check whether right sorted
                else{
                    // check which interval the target locates.
                    if(nums[high] >= target && nums[mid] < target){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
            } 
        }
        return  -1;
    }
}
