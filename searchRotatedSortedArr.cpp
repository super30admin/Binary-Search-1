// Time Complexity : O(log n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        

        int leftIndex = 0;
        int rightIndex = nums.size() - 1;
        int mid;


        while(leftIndex<=rightIndex)
        {
            mid = leftIndex + (rightIndex-leftIndex)/2;
            if(nums[mid] == target)
            {
                return mid;
            }

            if(nums[leftIndex] <= nums[mid]) //left sorted array
            {
                if(target>=nums[leftIndex] && target < nums[mid])
                {
                    rightIndex = mid - 1;
                }
                else
                {
                    leftIndex = mid + 1;
                }
            }
            else //right sorted
            {
                if(target>nums[mid] && target <= nums[rightIndex])
                {
                    leftIndex = mid + 1;
                }
                else
                {
                    rightIndex = mid - 1;
                }
            }
        } 
        return -1;  

    }
};