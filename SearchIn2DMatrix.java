// tc = o(log(r*c)) where r is row and c is col
//sc = o(1) 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row*col -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid/col;
            int c = mid%col;
            int midElem = matrix[r][c];
            if(target == midElem){
                return true;
            }
            else if(target < midElem){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }

        }
        return false;
    }
}

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println( s.searchMatrix(matrix, 3));
       
    }
}