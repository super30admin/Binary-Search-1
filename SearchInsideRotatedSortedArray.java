//Time Complexity O(log n)
//Space Complexity O(1)
//Yes

class Solution {
    public int search(int[] nums, int target) {
        
        int high = nums.length-1;
        int low = 0;
        int mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            
            if(target == nums[mid])
                return mid;
            
         if(nums[mid] >= nums[low]) {
             if(target >= nums[low] && target < nums[mid])
                high = mid - 1;
            else 
                low = mid +1;
        }
        
        else {
            if(target > nums[mid] && target <= nums[high])
                low = mid + 1;
            else 
                high = mid - 1;
        }
    }
           return -1;
 
    }
}
