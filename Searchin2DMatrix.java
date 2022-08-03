//time complexity: O(logmn)
//space complexity: O(mn)
// Did this code successfully run on Leetcode : Yes



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low= 0; 
        int m = matrix.length;  int n= matrix[0].length; 
        int high = m*n -1; 
        int row=0;  int col=0;
        // we are considering the sorted matrix to be 1D array and performing binary search
        //and to find the exact index of the middle element we are taking the mod and diving it by n number of cols
        
        while(low <= high){
            int mid = low + (high-low) / 2;
            row = mid / n;
            col = mid % n; // n is number of columns
            
            if(matrix[row][col] == target) return true; 
            
            else if (matrix[row][col] > target){
                high = mid -1; 
            }else {
                low = mid+1;
            }
        }
        return false; 
    }
}