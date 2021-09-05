// Time Complexity : O(M) // M is size of each row
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0) return false;
        int i = 0;
        while(i < matrix.size() - 1 && matrix[i + 1][0] <= target)
        {
            i++;
            if(matrix[i][0] == target) return true;
        }
        
        int left = 0;
        int right = matrix[0].size() - 1;
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (matrix[i][mid] == target) return true;
            else if (matrix[i][mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
};
