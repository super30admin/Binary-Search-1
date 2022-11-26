// Time Complexity : O(logmn)
// Space Complexity : O(1)
/*
 * The matrix is thought to be a single dimentional array and
 * we traverse though the matrix by getting the mid element and comparing
 * it with the target while using binary search.
*/

public class Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int low = 0;
        int high = (matrix.length*matrix[0].length)-1;
        int n = matrix[0].length;
        
        while(high >= low){
            int mid = low + (high-low)/2;
            int row = mid/n;
            int col = mid%n;
            int midElement = matrix[row][col];
            if (target == midElement) return true;
            if(target < midElement){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}

// Solution 2:
// Time Complexity : O(logmn)
// Space Complexity : O(1)
/*
 * we run the binary search for all rows and check which one has the
 * range for the target element and then we run the binary search
 * in that row and get the target value.
 */

class Solution2{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int arrayPosition = 0;
        int lowRange = 0;
        int highRange = matrix[0].length-1;
        while (arrayPosition < matrix.length){
            if(matrix[arrayPosition][0]<= target && matrix[arrayPosition][highRange] >= target) {
                while(highRange >= lowRange){
                    int mid = lowRange + (highRange-lowRange)/2;
                    int midElement = matrix[arrayPosition][mid];
                    if(midElement == target) return true;
                    else if(midElement > target){
                        highRange = mid-1;
                    }
                    else{
                        lowRange = mid+1;
                    }
                }
            }
            arrayPosition += 1;
        }
        return false;   
    }
}