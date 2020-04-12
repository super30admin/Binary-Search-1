// Iterative Solution
// Time Complexity - O(logN)
// Space Complexity - O(1)

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        int low =0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[low]){
                if(nums[mid] > target && nums[low] <= target){
                    high = mid -1;
                }
                else{
                    low = mid +1;
                }    
            }
            else{
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;    
                }
                else{
                    high = mid -1;
                }
                
            } 
        }    
        return -1;
    }
}

// Recursive Solution
// Time Complexity - O(LogN)
// Space Complexity - O(LogN) / due to the recursive stack space

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        int low =0;
        int high = nums.length-1;
        return helper(nums, target, low, high);
    }
    private int helper(int[] nums, int target, int low, int high){
        int mid = low + (high -low)/2;
        if(low > high)  return -1;
        if(nums[mid] == target) return mid;
        if(nums[mid] >= nums[low]){
             if(nums[mid] > target && nums[low] <= target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }    
        }
        else{
            if(nums[mid] < target && nums[high] >= target){
                low = mid + 1;    
            }
            else{
                high = mid -1;
            }
        }
        return helper(nums, target, low, high);
    }
}
