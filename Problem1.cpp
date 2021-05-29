// Time Complexity : O(log m + log n)
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        if(!matrix.size() || !matrix[0].size())
            return false;
        
        int m = matrix.size();  // calculate no of rows
        int n = matrix[0].size();   // calculate no of columns
        
        int low = 0;
        int high = m*n - 1;
        int mid;
        while(low <= high){
            mid = (low + (high-low)/2); // this has to be converted to row and column representation
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                high = mid - 1;
            }
            else{ 
                low = mid + 1;
            }
        }
        
        return false;
    }
};