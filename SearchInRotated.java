// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class SearchInRotated {
    public int search(int[] nums,int target){
        int s=0,e = nums.length-1;
        while(s<=e)
        {
            int m = s+(e-s)/2;
            if(nums[m]==target)
                return m;
            else if(nums[s]<=nums[m])      //First half has all increasing elements
            {
                if(target>=nums[s] && target<nums[m])   //Target lies in first half
                    e = m-1;
                else
                    s = m+1;
            }
            else                            //Second half has all increasing elements
            {
                if(target<=nums[e] && target>nums[m])   //Target lies in second half
                    s = m+1;
                else
                    e = m-1;
            }
        }
        
        return -1;
    }
}