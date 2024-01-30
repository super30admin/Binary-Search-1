class Solution {
public:
    // Time Complexity : O(logn)
    // Space Complexity :  O(1
    // Did this code successfully run on Leetcode :  O(logn)
    // Any problem you faced while coding this :  No

    /*
    We can consider the 2D array as a flattened 1D array
    Since the array is sorted, we can do binary search
    which will take O(log(n*m)) time
    */

    bool searchMatrix(vector<vector<int>>& mat, int target) {
        int m, n;
        m = mat.size();
        n = mat[0].size();

        int lo = 0, hi = m*n;

        while(lo<hi){
          int mid = lo+(hi-lo)/2;

          int row = mid/n, col = mid%n;

          if(mat[row][col] == target)  return true;
          if(mat[row][col] < target)  lo = mid + 1;
          else  hi = mid;
        }

        //if not found
        return false;
    }
};
