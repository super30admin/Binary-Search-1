// Time Complexity : O(m + log(n))
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The code assumes that the matrix is sorted in non-decreasing order both row-wise and column-wise. If the input matrix violates this assumption, the code may produce incorrect results or encounter an error.



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int n = matrix[i].length - 1;
            // Finding that row.
            if(target <= matrix[i][n]){
                // Binary Search
                int s = 0;
                int e = n;
                while(s <= e){
                    int mid = s + (e - s)/2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] < target){
                        s = mid + 1;
                    }else{
                        e = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}