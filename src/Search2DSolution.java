//Time complexity O(log n)
//Space complexity 0(1)

// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : NO
class Search2DSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return  false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high = m*n-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            //find row by diving no of columns
            //find col by modulus of no of columns
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c]>target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}