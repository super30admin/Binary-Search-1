//TC: O(log(m*n)) where mxn is the dimension of the matrix. 
//SC: O(1)

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        
        if(matrix.size() == 0)
            return false;

        int rows = matrix.size();
        int cols = matrix[0].size();
        
        int lo = 0;
        int hi = rows*cols - 1;
        
        
        while(lo <= hi){
            
            int mid = lo + (hi-lo)/2;
            int r = mid / cols;
            int c = mid % rows;
                   
            
            if(matrix[r][c] == target)
                return true;
            
            if(target > matrix[r][c]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }                 
        }
        
        return false;
        
    }
};