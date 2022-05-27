// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Search in Rotated Sorted Array

public class RotatedArray {
    
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0) return -1;
            int low = 0; int high = nums.length - 1;
               while(low<=high){
                   int mid = low + (high-low)/2;
                   if(nums[mid] == target) return mid;
                   else if(nums[low]<=nums[mid]){  //looking if the left side of mid is the sorted array or not and doing binary search if it is
                       if(target>=nums[low] && target<nums[mid]) high = mid-1;
                       else low = mid+1;
                   }else{ //looking if the right side of mid is sorted or not and doing binary search if it is
                       if(target>nums[mid] && target<=nums[high]) low = mid+1;
                       else high = mid-1;
                   } 
               } return -1;
        }
    
}
