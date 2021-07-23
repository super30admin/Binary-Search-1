// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NOPE


// Your code here along with comments explaining your approach
/*
Approach
1) perform a modified binary search
2) 1,2,3,4,5 -> if array is not rotated then normal binary search would work 
3) in case of rotation of array 4,5,1,2,3 we come across 2 ascending arrays 4,5 and 1,2,3
we check if nums[start]<nums[mid] and we come to know that the array is rotated when the condition is not statisfied


*/

class Solution {
    public int search(int[] nums, int target) {
      
       int start = 0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            //System.out.println(mid);
            
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[start]<=nums[mid])
            {
                if(target>=nums[start] && target<nums[mid])
                {
                    end =mid-1;
                }
                else
                {
                    start = mid+1;
                }
            }
            else
            {
                if(target>nums[mid] && target<=nums[end])
                {
                    start=mid+1;
                    
                }
                else
                {
                    end = mid-1;
                }
            }
        }
        
        return -1;
    }
}