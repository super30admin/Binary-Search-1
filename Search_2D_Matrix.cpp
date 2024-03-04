// Time Complexity : O(log n)  ... base for log is 2
// Space Complexity : O(4) ~ O(1) ... need to allocate 4 new variables, but its nothing but O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/search-a-2d-matrix/
Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
*/

/*
Code explanation : 
2-D array can be considered as 1-D array and binary search can be used on it.
Only complexity is to get exact index for row and column as we need to convert
1-D index into 2-D array index.

1-D array index/row_size gives row index
1-D array index%row_size gives column index
*/


class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {

        if(matrix.size() == 0) return false;

        int row_size = matrix[0].size();
        int low = 0;
        int high = (matrix.size() * row_size) - 1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(matrix[mid/row_size][mid%row_size] == target) {
                return true;
            }
            else if(matrix[mid/row_size][mid%row_size] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
};