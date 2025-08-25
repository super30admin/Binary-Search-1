// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The core idea behind this problem is "atleast one half of a rotated sorted array will be sorted at any give point in the binary search".
// We start by finding the mid element and comparing with element at index low and high to determine which half is sorted.
// Then we check if the mid lies in that sorted half or not, based on this, we manipulate the low and high pointers.

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } 
            if(nums[mid] >= nums[low]) { // left half is sorted
                if(nums[low] <= target and target < nums[mid]) { // lies in sorted left half
                    high = mid - 1;
                } else { // lies in the right half
                    low = mid + 1;
                }
            } else { // right half is sorted
                if(nums[mid] < target && target <= nums[high]) { // lies in sorted right half
                    low = mid + 1;
                } else { // lies in left half
                    high = mid - 1;
                }
            }
        }
        return -1; // not found
    }
};

int main() {
    Solution solution;
    vector<int> nums = {4,5,6,7,0,1,2};
    int index = solution.search(nums, 3);
    if (index == -1) {
        cout << "3 not found" << endl;
    } else {
        cout << "3 found at index " << index << endl;
    }
    index = solution.search(nums, 6);
    if (index == -1) {
        cout << "6 not found" << endl;
    } else {
        cout << "6 found at index " << index << endl;
    }
}