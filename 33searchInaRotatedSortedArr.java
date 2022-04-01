// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        //base case
        if(nums.length==0 || nums==null) return -1;
        
        int low=0;
        int high=nums.length-1;
        
        while(low<= high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){   //if target matches mid return
                return mid;
            }
            if(nums[low]<=nums[mid]){ //search left of mid
                if(nums[low]<=target && target< nums[mid]){
                    high=mid-1;
                }else low=mid+1;
            }else if(nums[mid]<target && target<=nums[high]){ //search on the right of mid
                low=mid+1;
            }else high=mid-1;
        }
        return -1;
    }
}