// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach: First, find the pivot (smallest element) using binary search.
// Perform binary search on the left and right halves separately based on the pivot.
// Return the index if found; otherwise, return -1.

class Solution {
    public int binary (int[] nums, int l,int r,int target)
    {
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] > target)
            {
                r = mid-1;
            }
            else
            {
                l= mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<r)
        {
            int mid = (l+r)/2;
            if(nums[mid] > nums[r])
            {
                l = mid+1;
            }
            else
            {
                r = mid;
            }
        }
        int op = binary(nums, 0,l-1,target);
        if(op  != -1)
        {
            return op;
        }
        return binary(nums, l,nums.length-1,target);
    }
}