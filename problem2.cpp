// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// our approach is based on the observation that atleast one half of the rotated array will be sorted. 
// we perform all our operations only on those sorted parts to get the answer.


class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.empty() || nums.size()==0) return -1;
        int lo = 0;
        int hi = nums.size() - 1;
        while(lo<=hi)
        {
            int mid = lo + (hi - lo)/2;
            if(nums[mid]== target) return mid;
            if(nums[lo]<=nums[mid])
            {
                if(target >= nums[lo] && target < nums[mid] )
                {
                    hi = mid - 1;
                }
                else
                {
                    lo = mid + 1;
                }
            }
            else
            {
                if(target > nums[mid] && target <= nums[hi])
                {
                    lo = mid + 1;
                }
                else 
                {
                    hi = mid - 1;
                }
            }
        }
        return -1;
        
    }
};