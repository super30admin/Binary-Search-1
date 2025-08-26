// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : earlier I had O(mlogn) solution but
// then later after the class, O(m+n) solution was interesting so I coded it up

// Your code here along with comments explaining your approach in three
// sentences only
// The first approach
// 1. Visualize this a 1d vector
// 2. Apply binary search and get the index mapping
// 3. Compare and move accordingly
// The other approach
// Start from bottom left or top right since one side would be decreasing and
// other would be increasing if target greater than curr element go forward in
// col otherwise decrease the row and go up
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  // This takes O(m+n) time complexity
  bool searchMatrix2(vector<vector<int>> &matrix, int target) {
    int m = (int)matrix.size();
    int n = (int)matrix[0].size();

    int i = m - 1;
    int j = 0;
    while (i >= 0 && j < n) {
      if (target == matrix[i][j]) {
        return true;
      } else if (target > matrix[i][j]) {
        j++;
      } else {
        i--;
      }
    }

    return false;
  }

  // Here we visualize our 2D array as 1D vector
  // This takes O(log mn)
  bool searchMatrix(vector<vector<int>> &matrix, int target) {
    int m = (int)matrix.size();
    int n = (int)matrix[0].size();

    int l = 0;
    int h = m * n - 1;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      int rowIdx = mid / n;
      int colIdx = mid % n;
      if (matrix[rowIdx][colIdx] == target) {
        return true;
      } else if (matrix[rowIdx][colIdx] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return false;
  }
};
