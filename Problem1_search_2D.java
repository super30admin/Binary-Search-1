//Time complexity:log(m+n)
//Space Complexity:log(1)
// code running on leetcode: yes 
//description: Used binary search to find the elemented in sorted matrix 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
        return false;
        int rows= matrix.length;
        int cols = matrix[0].length;
        int low =0;
        int high = rows*cols -1 ;
        while(low <= high){
        int mid = low +(high-low)/2;

        int r = mid/cols;
        int c = mid %cols;

        if(matrix[r][c]== target)
        return true ;
        else if (matrix[r][c]< target)
        {
            low = mid+1;
        }
        else 
            high = mid -1 ;
    }
    return false; 
    }
}
