// Time Complexity : O(log m + log n ) where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (matrix[mid][matrix[0].length - 1] < target) {
                low = mid + 1;
            } else if (matrix[mid][matrix[0].length - 1] >= target) {
                if (matrix[mid][0] <= target) {
                    int innerLow = 0, innerHigh = matrix[0].length - 1, innerMid;
                    while (innerHigh >= innerLow) {
                        innerMid = innerLow + (innerHigh - innerLow) / 2;
                        if (matrix[mid][innerMid] == target) {
                            return true;
                        } else if (matrix[mid][innerMid] < target) {
                            innerLow = innerMid + 1;
                        } else {
                            innerHigh = innerMid - 1;
                        }
                    }
                    return false;
                }
                high = mid - 1;
            }
        }
        return false;
    }
}
