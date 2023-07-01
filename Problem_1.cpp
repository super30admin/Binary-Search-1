/*
// Time Complexity : O(logn * log m) , where n = #rows, m = # cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
Doing row wise binary search in the 2d array to find out in which row the target might exist. 
Then doing a normal binary search on matrix[row][0] -> matrix[row][m-1]
Time : O (log n * log m) 
*/

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        bool res = false;
        int n = matrix.size();
        int m = matrix[0].size();
        int low = 0;
        int high = matrix.size();
        while(low <= high) {
            int mid = low + (high-low)/2;
            cout<<mid <<endl;
            if(mid <0 || mid >=n) {
                return false;
            }
            if(matrix[mid][0] <= target && target <= matrix[mid][m-1]) {
                low = mid;
                break;
            }else if(target > matrix[mid][m-1]) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        } 
        if(low <0 || low > n) {
            return false;
        }

        // search in matrix[low][0] -> matrix[low][m-1]
        int row = low;
        low = 0;
        high = m-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(matrix[row][mid] == target) {
                return true;
            }else if(target < matrix[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
};
