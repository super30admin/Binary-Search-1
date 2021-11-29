// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Solution2{
    public int search(int[] nums, int target) {
        if(nums==null ||nums.length==0)
            return -1;
        int len=nums.length;
        int low=0;
        int high=len-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            //left part is sorted
            if(nums[low]<=nums[mid]){
                //check if target lies between low and mid
                if(nums[low]<=target && target<nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            //right part is sorted
            else{
                //check if target lies between low and mid
                if(nums[mid]<target && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
}