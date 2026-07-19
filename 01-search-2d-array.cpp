/*
TC - O(log(m*n)) - since we perform binary search on a flattened form of the 2d array
SC - O(1) - no additional space utilised
Issues Faced - have seen this problem before, but remembering that the mid position can be extrapolated using division and modulo can be difficult if I revisit this problem only once a year. Need more closely spaced repetition, that's all.
Solved on Leetcode - yes


*/


class Solution {
    public:
        bool searchMatrix(vector<vector<int>>& matrix, int target) {
    
            int m = matrix.size();
            int n = matrix[0].size();
    
            int assumedSize = m*n;
    
            int low = 0;
            int high = m*n - 1;
    
            while (low <= high) {
                int mid = (low + (high-low)/2);
    
                int midRow = mid/n;
                int midCol = mid%n;
                int val = matrix[midRow][midCol];
    
                if (val == target) {
                    return true;
                } else if (val < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
    
            return false;
            
        }
    };
