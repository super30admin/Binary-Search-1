// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// I am treating the 2D matrix like a single straight line array and using binary search on it. 
// I convert the index into row and column to get the correct number from the matrix.
// This way, I can search faster without going row by row.

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();      
        int n = matrix[0].size();  

        int left = 0;
        int right = m * n - 1;   

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;       
            int col = mid % n;  

            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
};
