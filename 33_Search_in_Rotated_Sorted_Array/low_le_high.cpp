// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size()-1;
        while(low <= high) {
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
        return -1;
    }
};

int main() {
    vector<int> nums{4,5,6,7,0,1,2};
    int target = 0;
    Solution S;
    cout<<S.search(nums,target)<<endl;
}