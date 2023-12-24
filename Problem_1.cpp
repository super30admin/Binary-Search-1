/*
 * Time Complexity : O(log(n) + log(m))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   I'm using a binary search in the rows first to find the row
   in which theh target element can be. The I again use a binary
   search in that row to search of the target element.
*/

#include <vector>

class Solution {
public:
    bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {
        int lowRow = 0;
        int highRow = matrix.size() - 1;

        while (lowRow < highRow) {
            int mid = lowRow + (highRow - lowRow) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target && target < matrix[mid + 1][0]) {
                lowRow = mid;
                break;
            }
            if (matrix[mid][0] < target) {
                lowRow = mid + 1;
            } else {
                highRow = mid - 1;
            }
        }

        int lowCol = 0;
        int highCol = matrix[0].size() - 1;

        while (lowCol <= highCol) {
            int mid = lowCol + (highCol - lowCol) / 2;
            if (matrix[lowRow][mid] == target) {
                return true;
            }
            if (matrix[lowRow][mid] < target) {
                lowCol = mid + 1;
            } else {
                highCol = mid - 1;
            }
        }

        return false;
    }
};