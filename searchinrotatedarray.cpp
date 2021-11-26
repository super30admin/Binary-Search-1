#include <iostream>
#include <vector>

using namespace std;

// Time Complexity : O(log n)
// Space Complexity : O(1) Constant Space
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = high - 1;
                }
            }
        }
        
        return -1;
    }
};