// Time Complexity : O(log2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We will solve this using binary search. Based on mid value, we need to first find which(left/right) sub array is sorted.
// Depending on sorted sub array and target we will determine low and high corespondingly. we do binary search repeatedly to get desired result

#include <cstdlib>
#include <vector>

class Solution {
public:
    int search(std::vector<int>& nums, int target) {
        if(nums.size() == 0)
        {
            return 0;
        } 
        size_t inputSize = nums.size();
        int low = 0; 
        int high = inputSize-1;

        while(low <= high)
        {
            // calculating mid
            int mid = (low + (high-low)/2);
            if(nums[mid] == target)
            {
                return mid;
            }
            // left sub array is sorted 
            if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && nums[mid] > target)
                {
                    high = mid -1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else //Right sub array is sorted
            {
                if(nums[mid] < target && nums[high] >= target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
};