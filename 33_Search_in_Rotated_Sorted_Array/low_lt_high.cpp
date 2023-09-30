// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Technique: Binary Search
// By pivoting property, we know that at any point in the array, either the left or right subarray will be sorted.
// Take mid of 0 to n-1. If the first half is sorted, then check if the target can lie in this range. If yes search in this half else in second half.
// Similarly, if second half is sorted and the target lies in this half then search their else in first half.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size()-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]) { // First half sorted
                if(nums[low] <= target && nums[mid]>target) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        if(nums[low] == target) {
            return low;
        }
        return -1;
    }
};

int main() {
    vector<int> nums{4,5,6,7,0,1,2};
    int target = 0;
    Solution S;
    cout<<S.search(nums,target)<<endl;
}