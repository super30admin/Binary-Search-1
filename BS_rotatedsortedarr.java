// Time Complexity :O(log n)
// Space Complexity :o(n) n-length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didnt get the idea for solution. Learned and did


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2; // Find mid
            if(nums[mid]==target)
                return mid;
            if(nums[start]<=nums[mid]) // Checking If numbers between start and mid are sorted
            {
                if(nums[start]<=target && target < nums[mid]) // Checking If target is between the sorted range
                    end=mid-1;
                else
                    start=mid+1; // else then target is between mid+1 and end
            }
            if(nums[mid]<=nums[end]) // Checking if numbers between mid and end are sorted
            {
                if(nums[mid]<target && target<=nums[end]) // Checking if the target is in this range
                    start=mid+1;
                else
                    end=mid-1; else then target is between start and mid-1
            }
            
        }
        return -1;
    }
}