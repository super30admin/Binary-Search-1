
// Time Complexity : O( log mn )
// Space Complexity : None excpet matrix given
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE


// Your code here along with comments explaining your approach
Divide the matrix in half each time and search in one half 

class Solution {
public:
    
    bool searchMat( vector<vector<int>>& matrix, int left, int right, int target, int rows, int cols ) {
        
        if( left > right ){
            return false;
        }
        int mid = ( left + right )/2;
        if( matrix[mid/cols][mid%cols] == target ){
            return true;
        } else if ( target > matrix[mid/cols][mid%cols] ){
            return searchMat( matrix, mid + 1, right, target, rows, cols  );
        } else {
            return searchMat( matrix, 0, mid-1, target, rows, cols  );
        }
    }
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int total = rows * cols;
        int left =0; int right=rows * cols -1;
        return searchMat( matrix, left, right, target, rows, cols);
    }
};
