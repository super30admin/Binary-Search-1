// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        //if empty array is given
        if(nums==null||nums.length==0)
            return -1;
        //taking low and high values of the array
        int low=0, high=nums.length-1;
        //apply binary search
        while(low<=high){
            int midValue=low+(high-low)/2;
            //if in array we found the target
            if(nums[midValue]==target)
                return midValue;
            //else check which part is sorted
            //check if left half is sorted
            else if(nums[low]<=nums[midValue])
                //checking if target is in left half
                if(nums[low]<=target&&target<nums[midValue])
                    high=midValue-1;
                else
                    low=midValue+1;
            //else right side of array is sorted
            else
                if(nums[midValue]<target&&target<=nums[high])
                    low=midValue+1;
                else
                    high=midValue-1;
        }
        return -1;
    }
}