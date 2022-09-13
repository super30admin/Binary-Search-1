// Time complexity : O(log n)
// Space Complexity : O(1)
//worked on leetcode
class Solution {
    public int search(int[] nums, int target) {
        
        int low=0;
        int high= nums.length-1;
        
        if(nums==null || nums.length==0)
            return -1;
        
        while(low<=high){
            
            int mid= low+(high-low)/2;
            if(target==nums[mid])
                return mid;
            
            // if left sorted
            if(nums[low]<=nums[mid]){
                if(target >=nums[low] && target< nums[mid]){
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            
             // if right sorted

            else{
                if(target > nums[mid] && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            
        }
        return -1;
    }
}