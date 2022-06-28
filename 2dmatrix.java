// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        
        while(low<=high){
            int mid = low+ (high-low)/2;    //prevent integer overflow
            int row = mid/n;    //to find row in which element is present
            int col = mid%n;    //to find column in which element is present
            
            if(target == matrix[row][col])
            {
                return true;
            }
            else if(target<matrix[row][col]){   //if target is on left side of mid
                high = mid - 1;
            }
            else{                               //if target is on right side of mid
                low = mid + 1;
            }

        }
            return false;

    }
}