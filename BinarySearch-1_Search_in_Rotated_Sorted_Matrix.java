Time Complexity - O(log(n))
Space Complexity - O(n)
import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        
       int left = 0;
       int right = nums.length -1;
       int mid = left + (right -left)/2;
        
        while(left <= right){
            mid = left + (right -left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[left])
            {
                if(nums[mid] >= target && nums[left] <= target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else
               {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid+1;
                }else
                    right = mid-1;
            }
        }
        
        return -1;
        
        
    }
}