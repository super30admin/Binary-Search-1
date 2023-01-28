// Time Complexity : O(log m * n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        // TC = O(log m * n)
        //  NULL
        if (matrix.size() == 0)
            return false;
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0;
        int high = (m * n) - 1;
        // implementing BS
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;
            // implement BS
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
};