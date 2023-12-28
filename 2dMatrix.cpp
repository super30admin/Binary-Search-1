// Time Complexity : O(log m * n), where m is no of rows and n is no of cols
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int low =0;
        int high = matrix.size()*matrix[0].size()-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int row = mid/matrix[0].size();
            int column = mid%matrix[0].size();
            if(matrix[row][column] == target)
                return true;
            else if(matrix[row][column]<target)
            {
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return false;
    }
};