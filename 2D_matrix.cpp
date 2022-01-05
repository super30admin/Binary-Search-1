// Time complexity : O(log(mn)) 
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
      if(matrix.size()==0) return false;
        
      int row = matrix.size();  
      int col = matrix[0].size();      
      int low = 0;
      int high = row*col-1;
        
      while(low <= high){
          
        int mid = low+(high-low)/2;     
        int r = mid/col;
        int c = mid%col;
        
        if(target == matrix[r][c]){
            return true;
        }
        else if(target < matrix[r][c]){
            high=mid-1;
        }
        else if(target > matrix[r][c]){
            low=mid+1;
        }
    
       }
            return false;    
    }
};
