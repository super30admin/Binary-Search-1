// Time Complexity : O(log (m * n)) - bineary serached through only half of the rows and cols
// Space Complexity : O(1) - haven't used any extra space to perform the operations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Leetcode(74): https://leetcode.com/problems/search-a-2d-matrix/
/*Approach:
    Solution is to image the matrix like a sorted 1D array without actually no performing any flattening ops and accessing them by thier 2D indices.
    Explained more on how i implement that in the solution below with some comments.

*/
#include<iostream>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
    
        int rows = matrix.size(), cols = matrix[0].size();

        //treat it like a 2D array which contains low, high which is at n * m
        int low = 0, high = (rows * cols) - 1;

        //do normal binary search
        while(low <= high){
            //calculate mid
            int mid = low + (high - low)/2;

            //Now i needed find where the mid element is located on n * m array
            //Example 1: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
            //mid is 5 ( 3 * 4  = 12 element .i.e 0...11) and it's correspondent location on matrix is ( 1 * 1) 
            //to get to 5 i need 1x1 matxtir[i][j]
            //trick here is to het 1 x 1 : to calculate i: index / columns and j: index % columns.
            // 5/4 = 1 and 5 % 4 = 1 which 1 * 1 the location i wanted. Same for 3 it on index 1(0*1)...1 / 4 = 0 and 1 % 2 = 1;
            int i = mid/cols;
            int j = mid%cols;

            if(matrix[i][j] == target){
                return true;//target found
            }
            else if(target > matrix[i][j]){
                low = mid + 1; 
            }
            else{
                high = mid - 1;
            }
        }
        return false; // target not found
    }
};