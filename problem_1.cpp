// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        if(matrix.size() == 0) {
            return false;
        }
        if(matrix.size() == 1) {
            if (matrix[0][0] == target) return true;
        }
        int n = matrix[0].size();
        int m = matrix.size();
        
        int l  = 0;
        int h = (m * n) - 1;
        
        while(l <= h) {
            int m  = l + (h -l) / 2;
            int r = m / n;
            int c = m % n;
            if (matrix[r][c] == target) return true;
            
            else if (matrix[r][c] > target) h = m - 1;
            
            else l = m + 1;
        }
        
        return false;
    }
};
