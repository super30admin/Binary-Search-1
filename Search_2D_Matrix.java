// Time Complexity :O(log mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Treat the matrix as flattened array and do binary search. 
// Corresponding mapping: row = mid/n, column = mid%n 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n=matrix[0].length;
        int low,mid,high;
        low=0;
        high = m*n-1;//last element

        while(low<=high){
            mid=low+(high-low)/2;
            int row = mid/n;
            int column = mid%n;
            if(matrix[row][column] == target){
                return true;//target found
            }
            else if(matrix[row][column] > target){
                high = mid - 1;//search in left side
            }
            else{
                low = mid + 1;//search in right side
            }
        }
        return false;//not found
        
    }
}
