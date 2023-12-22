// Time Complexity : O(log(m*n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Made the 2d vector into 1d vector and
// performed binary search on it using row = mid/n and
// column = mid%n

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        int m = matrix.size();
        int n = matrix[0].size();
        int mid, low = 0, high = m * n - 1;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            if (matrix[mid / n][mid % n] == target)
            {
                return true;
            }
            else if (matrix[mid / n][mid % n] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return false;
    }
};