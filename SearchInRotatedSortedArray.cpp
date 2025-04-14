// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()==0)
        {
            return -1;
        }
        
        int low=0;
        int high=nums.size()-1;
        
        while(low<=high)
        {
            int middleElement=low + (high-low)/2;
            
            if(nums[middleElement]==target)
            {
                return middleElement;
            }
            
            if(nums[low]<=nums[middleElement])
            {
                //Left side is sorted
                if(target<nums[middleElement] && target>=nums[low])
                {
                    //Number is on the sorted side
                    high=middleElement-1;
                }
                else
                {
                    //Number not on the sorted side
                    low=middleElement+1;
                }
            }
            else
            {
                //right side is sorted
                if(target>nums[middleElement] && target <=nums[high])
                {
                    low=middleElement+1;
                }
                else
                {
                    high=middleElement-1;
                }
            }
        }
        return -1;
    }
};