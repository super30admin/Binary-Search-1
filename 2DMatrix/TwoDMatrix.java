// Time Complexity : O(logm+logn)
// Space Complexity :O(mn)

class TwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;

        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;

    }

    public static void main(String args[]) 
    { 
        TwoDMatrix ms = new TwoDMatrix();  
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean val=ms.searchMatrix(matrix, 13);
        System.out.println(val);

        
        
        
    }
}