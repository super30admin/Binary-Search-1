// Time Complexity : O(log(n*m)) -> O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Convert 2D matrix to 1D in a virtual sense and not literal sense and apply binary search

#include <iostream>
#include <vector>
  
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size() == 0) return false;
        int c = matrix[0].size();
        int r = matrix.size();
        int low = 0;
        int high = c*r - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int ridx = mid / c;
            int cidx = mid % c;
            if(matrix[ridx][cidx] == target) return true;
            else if(matrix[ridx][cidx] >= target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
};