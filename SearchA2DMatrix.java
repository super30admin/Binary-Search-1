//Problem - Search A 2D Matrix 
//Leetcode Problem link - https://leetcode.com/problems/search-a-2d-matrix/description/

//Time complexity - O(log(m*n)) 
//Space complexity - O(1) - No additional data structure used
//Solution:

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row*col-1;

        while(low<= high){
            int mid = low + (high - low)/2;

            if(matrix[mid/col][mid%col] == target) return true;

            else if (matrix[mid/col][mid%col] > target){
                high = mid -1;
            } 
            else low = mid+1;
        }
        return false;
    }    

    public static void main(String args[]){
        SearchA2DMatrix obj = new SearchA2DMatrix();
        int [] [] martrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(obj.searchMatrix(martrix, target));
    }
}
