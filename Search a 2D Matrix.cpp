//74. Search a 2D Matrix

/*

Binary search implementation

Time complexity: O(log m + log n)
Space complexity: O(1)

*/

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
      
	  
        //convert to 1D array
        if(matrix.size() == 0) return false;
        int m = matrix.size();
        int n = matrix[0].size();

        int low = 0, high = m*n - 1;

        while(low <= high){
            int mid = low +(high - low) /2;

            int r = mid / n;
            int c = mid % n;

            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) low = mid+1;
            else high = mid -1;
        }

        return false;

        
    }
};