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




/* Will work more on this 

class Solution {
    public int search(int[] nums, int target) {
        
        int length=nums.length;
        int left = 0;
        int right = length-1;
        mid= (right - left)/2;
        while(left<=right)
        {
            if(target == nums[mid]) return mid;
            else if (target <=nums[mid])
            {
                if(nums[left]<nums[right] && nums[mid]>=nums[left] && nums[mid]<=nums[right]) 
                {
                    
                }
            }
            else
            {
                
            }
        }
    }
}

*/
