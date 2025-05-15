// Time Complexity : O(m + log n), where m = number of rows, n = number of columns
// Space Complexity : O(log n) due to recursion stack (in worst case)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// I didn't get the idea to do it in log(m*n). So, I used a binary search within rows,
// but scanned rows linearly to find a suitable one. This gives O(m + log n) time, 
// which doesn't meet the optimal O(log(m * n)) requirement mentioned in the problem.

// Your code here along with comments explaining your approach in three sentences only
// I checked each row's last element to determine if the target could be in that row.
// If the target was less than or equal to the last element of a row, I performed a binary search on that row.
// This works functionally, but since it linearly checks rows, it doesn't meet the strict O(log(m * n)) time requirement.

class Solution {
public:
    bool binarySearch(vector<vector<int>>& matrix,int l, int r, int target,int row){
        if(l > r) return false;
        int mid = l + (r - l) / 2;
        if(matrix[row][mid] == target)
            return true;
        else if(matrix[row][mid] > target)
            return binarySearch(matrix, l, mid - 1, target, row);
        else
            return binarySearch(matrix, mid + 1, r, target, row);
    }

    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size();
        int col = matrix[0].size();
        for(int i = 0; i < row; ++i){
            if(matrix[i][col - 1] == target)
                return true;

            if(matrix[i][col - 1] > target) {
                return binarySearch(matrix, 0, col - 1, target, i);
            }
        }
        return false;
    }
};
