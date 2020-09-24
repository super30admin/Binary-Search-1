// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//If my mid=target…I’m good to go, then I will check if my left is<mid then I can assume 
//that my left part is sorted, then I will check if my target is bw left and mid. Same applies for right



class RotatedSortArray {
    public int search(int[] nums, int target) {
        int l = 0,m;
        int r = nums.length-1;
        
        if(nums == null || nums.length==0){
            return -1;
        }
        
        while(l<=r){
            m = l+(r-l)/2;
            
            if(nums[m]==target){
                return m;
            }
            else if(nums[l]<=nums[m]){
                if(target>=nums[l] && target<nums[m]){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            else{
                if(target>nums[m] && target<=nums[r]){
                    l=m+1;
                }
                else{
                    r=m-1; 
                }
            }
        }
        return -1;
    }
}