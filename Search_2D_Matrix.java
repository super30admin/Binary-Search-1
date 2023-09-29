// Time Complexity : O(log (m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

public class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int h = (m*n)-1;

        while(l<=h){
            int mid = l+(h-l)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col]<target){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return false;  
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        Search_2D_Matrix obj = new Search_2D_Matrix();
        boolean isPresent = obj.searchMatrix(matrix, target);
        System.out.println("Target present: " + isPresent);

        int target2 = 13;
        boolean isPresent2 = obj.searchMatrix(matrix, target2);
        System.out.println("Target present: " + isPresent2);

    }
}
