// Time Complexity : O(logN + logM)
// Space Complexity : O(1) as I didn't use any extra space, just the temporary variables
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : As I didn't put a break after finding the row it ended in infinite loop, 
Corrected after going through the code again */
// Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
// Submission Link: https://leetcode.com/submissions/detail/526739898/

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int start = 0, end = matrix.size() - 1;
        int col = matrix[0].size() - 1;
        
        int mid;
        int row = -1;
        
        // Find the row in which the element could be present
        while(start <= end){
            mid = (start + end) / 2;
            
            if(target >= matrix[mid][0]  && target <= matrix[mid][col]){
                row = mid;
                break;
            }
            else if(target < matrix[mid][0])
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        // If there is no such row return false
        if(row == -1)
            return false;
        
        start = 0, end = matrix[row].size() - 1;
        
        // Find the column in particular row
        while(start <= end){
            mid = (start + end) / 2;
            
            if(target == matrix[row][mid])
                return true;
            else if(target < matrix[row][mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        return false;
    }
};