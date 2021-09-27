class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0, high = n*m-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int i = mid/n;
            int j = mid%n;
            
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j]<target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return false;
    }
};

// Time Complexity: o(logn)
// Space Complexity: o(1)
// Run on Leetcode: Yes
