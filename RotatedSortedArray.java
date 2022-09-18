// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RotatedSortedArray {
        public int search(int[] nums, int target) {
           if(nums ==null || nums.length == 0) 
               return -1;
            //binary search
            int low=0;
            int high =nums.length -1;
            while(low<=high){
                int mid= low+(high-low)/2;
                //instead of (high+low)/2 as it causes inteager overflow
                if(nums[mid]==target){
                    return mid;
                }
                //left part sorted
                if(nums[low] <= nums[mid]){
                    if(target>=nums[low] && target< nums[mid]){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
                // else rightpart sorted
                else{
                    if(target>nums[mid] && target <=nums[high]){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
        }return -1;
            
    }
    }

