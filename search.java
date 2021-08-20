// Time Complexity :log (n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


public class search {
    public int search(int[] nums, int target) {
        //Taking null condition into consideration
        if(nums==null || nums.length==0) return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid= low + (high-low)/2;
            if(nums[mid]==target) return mid;
            //if left side is sorted then move high to mid-1
            else if(nums[low]<=nums[mid]){
                //check if target lies in this range
                if(nums[low]<=target && nums[mid]>target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }

                
            }
            else{
                if(nums[mid]<target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }

        }
        return -1;
    }
}
