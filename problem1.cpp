// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// we treat the matrix as if it was an array and do binary search
// for accessing row and column , we use row = mid/no. of columns and column = mid/no. of columns



class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty() || matrix.size()==0)
        {
            return false;
        }
        int m = matrix.size();
        int n = matrix[0].size();
        int lo = 0, hi = m*n -1;
        while(lo<=hi)
        {
            int mid = lo+ (hi-lo)/2;
            int row = mid/n;
            int col = mid %n;
            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col])
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return false;
        
    }
};