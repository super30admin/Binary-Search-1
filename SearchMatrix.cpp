// Time Complexity : O(MN) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0) return false;
        int row = 0, col = 0;
        int left = 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int right = (m * n) - 1;
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            row = mid / n;
            col = mid % n;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
};
