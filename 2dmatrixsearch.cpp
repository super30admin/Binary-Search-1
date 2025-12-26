class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();

        int low = 0, high = m * n -1;// minus because its array representation

        while(low <= high){
            int mid = low + (high - low)/2;
            // low + high / 2 isnt used to prevent integer overflow condition 
            int r = mid / n;
            // returns the row
            int c = mid % n;
            // returns the column

            if (matrix[r][c] == target){
                return true;
            }
            else if (matrix[r][c] > target){
                high = mid - 1;
                //move the high pointer one step down from mid since target isnt in right side of mid
            }
            else {//else if(matrix[r][c] < target) can also be used here but in order to make sure all are test cases are addressed we else.(not that edge cases exist here,but if they do exist scenario)
                low = mid + 1;
                // move the low pointer one step up from mid since target isnt in left side of mid
            }
        
        }

        return false;
        // even if after all this computation target isnt found we return false.

    }
};