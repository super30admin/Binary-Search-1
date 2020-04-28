// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : finding the correct condition for changing the low and high 
//                                           pointers
// Your code here along with comments explaining your approach

class Solution {

    
    private int mainSearch(int l, int h, int[]nums, int target){
        
            
        if(l>h)
            return -1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target)
                return m;
            else if(nums[l]<=nums[m]){
                if(nums[l]=target && nums[m]=target)
                    h=m-1;
                else
                    l=m+1;
            }
            else{
                if(nums[m]=target && nums[h]=target)
                    l=m+1;
                else
                    h=m-1;
            }
        }
        return mainSearch(l,h,nums,target);
    }
    
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int l=0,h=nums.length-1;
        if(nums[l]>target && nums[h]<target)
            return -1;
        
        if(nums[l]==target)
            return l;
        if(nums[h]==target)
            return h;
        
        return mainSearch(l,h,nums,target);
    
    }
}
