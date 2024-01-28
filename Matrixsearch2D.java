//Time complexity = O(log n)
//Space complexity = O(1) - No auxilary thing have been used
// Run on leetcode - yes
// challange - finding in index, referred class video and copied kinda 

//Consider 2D array as 1D and then get low, high, mid
// because this 2D array. calculate row depends on column
//mid/n = row, mid%n = col : this is hard to remember : Good tip

public class Matrixsearch2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null) return false;
        if(matrix.length == 0) return false;
        if(matrix[0][0]>target) return false; // strictly increasing order.

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n -1; 
        int mid = 0;

        while(low<=high) {
            mid = low + (high-low)/2;
            int row = mid/n;
            int col = mid%n;
            System.out.println(matrix[row][col]);
            if(matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target){
                low = mid+1;

            }else {
                high = mid-1;
            }
        }

        return false;
            
    }

    public static void main(String[] args){
        Matrixsearch2D obj = new Matrixsearch2D();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean a = obj.searchMatrix(matrix, 3);
        System.err.println(a);
    }
}
