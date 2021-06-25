// Time Complexity: O(log MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No


class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n-1;
        int mid, val;
        
        while(start <= end) {
             mid = (start+end)/2;
             val = matrix[mid / n][mid % n];;
            if(val == target) {
                return true;
            } else {
               if(target < val) {
                     end = mid - 1;
              } else {
                   start = mid + 1;
               }
            }    
        }
        return false;
    }
}
