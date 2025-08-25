// Time Complexity : O(log m*n), since we are performing binary search on m*n elements
// Space Complexity : O(1), no additional space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The approach here is to think of this 2D matrix as a 1D array, without converting it explictly. 
// We can set low = 0 and high = m*n-1 and perform binary search to find the target.
// Once we get mid, we need to convert it to row and column index using the formula r = mid / n & c = mid % n, then proceed with normal binary search.

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(); // rows
        int n = matrix[0].size(); // columns

        int low = 0;
        int high = m*n-1; // total number of elements - 1

        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid / n; // calculate row-index
            int c = mid % n; // calculate col-index
            if(matrix[r][c] == target) { // standard binary search conditions
                return true;
            } else if(matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false; // we did not find the target in the matrix
    }
};

int main() {
    Solution solution;
    vector<vector<int>> matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    cout<<(solution.searchMatrix(matrix, 3) ? "3 exists in the matrix." : "3 was not found in the matrix.")<<endl;
    cout<<(solution.searchMatrix(matrix, 35) ? "35 exists in the matrix." : "35 was not found in the matrix.")<<endl;
}