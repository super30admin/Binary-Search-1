// Time Complexity : O(log(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Problem1 Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if (m == 0) return false;
        int n = matrix[0].size();

        //get start and end of the matrix
        int start = 0;
        int end = m * n - 1;

        //for binary search get mid value
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = matrix[mid / n][mid % n];

            //check if midval is equal to target or else, compare it to decide which side of matrix to move
            if (midVal == target) {
                return true;
            } else if (target < midVal) {
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }
// if target isnt found return false
        return false;
    }
};

