// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//Search in a Rotated Sorted Array

// Your code here along with comments explaining your approach in three sentences only : 
//Used Binary search

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        int low = 0, high = n-1;//It maintains two pointers, low and high, to perform binary search. 

        //The algorithm adapts its search based on whether the current segment is sorted or rotated, efficiently narrowing down the search space until finding the target or determining its absence.


        while(low<=high)
        {
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target <= nums[mid])
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
                if(nums[mid] <= target && target <= nums[high])
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