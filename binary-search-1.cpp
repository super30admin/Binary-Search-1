class Solution {
public:
      bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        if(matrix.empty()) return false;
        
        int rsize = matrix.size();
        int csize = matrix[0].size();
        
        int min = 0;
        int max = rsize * csize - 1;
        
        while(min <= max){
            int mid = (min +max)/2;
            int r = mid/csize;
            int c = mid%csize;
            
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) min = mid + 1;
            else max = mid - 1;
        } 
        return false;       
    }
};