class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // Before this we implemented this using linear search of the index and then
        // binary search of the row
        // For doubt check s30 video
        int low = 0;
        int mid = 0;
        int numOfRows = matrix.size();
        int numOfColumns = matrix[0].size();
        int row = 0;
        int column = 0;
        int high = (numOfRows * numOfColumns) -1;
        while(low <= high){
            mid = (low + high)/2;
            row = mid/numOfColumns;
            column = mid % numOfColumns;
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] > target){
                high = mid-1;
            }else if(matrix[row][column] < target){
                low = mid +1;
            }
        }
        return false;
    }
};