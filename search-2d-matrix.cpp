// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    bool BS(vector<vector<int>>& matrix, int l, int r, int target, int m, int n)   {
        while(l <= r)    {
            int mid = l+(r-l)/2;
            if(target == matrix[mid/n][mid%n])    return true;
            else if(target > matrix[mid/n][mid%n])    l = mid+1;
            else    r = mid-1;
        }
        return false;
    }
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        return BS(matrix, 0, m*n-1, target, m, n);
    }
};