// Time Complexity : O(n)   
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No




public class RotatedSortedArray {
    
    public int search(int[] nums, int target) {
        
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]==target) return i;
        }
        return -1;
    }


}
