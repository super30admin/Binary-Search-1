// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, just l < r and making sure I
// check for bounds

// Your code here along with comments explaining your approach in three
// sentences only

// Here for each we reduce the search space by 1/2 since we look atleast one
// side will be sorted
// Then use binary search and check if low <= mid, then left half is sorted
// then check if the low <= target and target <= mid, target lies in the range
// otherwise go the other half
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int search(vector<int> &nums, int target) {
    int n = (int)nums.size();
    int l = 0;
    int r = n;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[l] <= nums[mid]) {
        if (nums[l] <= target && target <= nums[mid]) {
          r = mid;
        } else {
          l = mid + 1;
        }
      } else {
        if (nums[r - 1] >= target && target >= nums[mid]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
    }

    return -1;
  }
};
