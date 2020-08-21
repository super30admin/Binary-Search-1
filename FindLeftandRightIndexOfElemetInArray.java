// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = findLeftmostIndex(nums,target);
        int right = findRightmostIndex(nums,target);
        
        return new int[] {left,right};
    }
    
    public int findLeftmostIndex(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
           int mid=low+(high-low)/2;
            
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                    return mid;
                }
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    
    public int findRightmostIndex(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
           int mid=low+(high-low)/2;
            
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }
                low=mid+1;
            }else if(nums[mid]<target){
                low=mid+1;;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}