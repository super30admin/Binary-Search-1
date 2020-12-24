// Time Complexity : O(mn)
// Space Complexity : O(1) -> contant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class searchMatrix {
    //Dims of matrix
    int m, n=0;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        if(m > 0)
            n = matrix[0].length;
        
        int num_elements = m*n;
        int start = 0;
        int end = num_elements-1;
        int mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            if(matrix[mid / n][mid % n] == target)
                return true;
            else if(matrix[mid / n][mid % n] < target)
                start = mid + 1;
            else
                end = mid -1;   
            }
        return false;
    }
}