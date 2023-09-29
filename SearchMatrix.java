// Time Complexity :O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int l = 0, h = m*n-1;

            while(l <= h){
                int mid = l+(h-l)/2;
                int r = mid/n;//gives row
                int c = mid%n;//gives col

                if(matrix[r][c] == target) {
                    return true;
                }

                else if(matrix[r][c] > target){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            return false;
        }
    }
}
