// Time Complexity : O(log n)
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else 
                if(nums[low] <= nums[mid]){      // check if left part is sorted
                    if(target >= nums[low] && target < nums[mid])  //check if present in the sorted part           
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
            else  {      // if right part is sorted
                if(target > nums[mid] && target <= nums[high]) //check if present in the sorted part
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return -1;
    }
};