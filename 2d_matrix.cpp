// Time Complexity : O(log2m + log2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Considering elements as in a 1d matrix and perform binary search. we use formulas to look up actual row and col number 

#include <vector>

class Solution {
public:
    bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {
        if(matrix.size() == 0)
        {
            return false;
        }
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0;
        int high = m*n - 1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target)
            {
                return true;
            }
            else if(matrix[r][c] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return false;
    }
};