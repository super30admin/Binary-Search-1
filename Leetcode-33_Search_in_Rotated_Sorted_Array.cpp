// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initially on deciding search space.

class Solution {
public:
    int search(vector<int>& nums, int target) 
    {
        int low =0;
        int high =nums.size()-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(nums[mid]==target)
                return mid;
            
            if(nums[low]<=nums[mid]) // left half is sorted
            {
                if(target>= nums[low] && nums[mid] > target) // target between low and high
                    high=mid-1;
                else
                    low = mid+1; // ele in unsorted half
            }
            
            else // right half is sorted
            {
                if(nums[high] >= target && target > nums[mid]) // target between low and high
                    low = mid+1;
                else
                    high = mid-1; // ele in unsorted half
            }
                  
        }
        
        return -1;
    }
};