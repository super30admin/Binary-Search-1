// This solution flattens the 2-D array into a single dimension virtually and does the normal binary search of it. The caveat of finding 2-D index from a flattened format is performed by transforming the index number based on Colum count.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int i=0,j=rowCount*colCount-1;
        while(i<=j) {
            int mid = i+(j-i)/2;
            // Row number is found based on the division of number of elements in each row
            int row = mid/colCount;
            // Col number is found based on the left elements in a particular row which is modulus operator
            int col = mid%colCount;

            if(matrix[row][col]==target) return true;
            if(matrix[row][col]>target) {
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return false;
    }
}
