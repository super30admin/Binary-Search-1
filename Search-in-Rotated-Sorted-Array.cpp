// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Apply Binary search where you will get one sorted side... check if that side is sorted and if it contains target
//If not go to the side and continue with the search as before

#include <iostream>
#include <vector>
  
using namespace std;


class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums == NULL || nums.size() == 0) return -1;
            if(nums[high] == target) return high;
            if(nums[mid] == target) return mid;
            if(nums[low] < nums[mid]){
                // left side sorted
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                // right is sorted
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
};