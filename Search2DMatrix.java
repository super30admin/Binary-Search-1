// Time Complexity - O(logn)
//Space Complexity - O(1)
//Worked on Leetcode
/* Major requirements for applying Binary search - array has to be sorted or partially sorted
* Access to the middle element
* In here the elements are sorted but we do not have access to the middle element.
* To gain access we calculate the row and col of the middle element. We divide the middle index by number of columns
* to get row and take mod of middle element with number of columns to get the col. We divide for calculating rows because
* as rows can decrease overtime when there are changes to start, end but number of columns would not change,and we take mod because we need to bind the columns.
* We then apply the basic binary search
* to calculate whether the target is present or no.
* */
public class Search2DMatrix {
    //https://leetcode.com/problems/search-a-2d-matrix/
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 20;
        System.out.println(searchMatrix(matrix,target));
    }

    //Below is the brute force approach for reaching the target
    //TC O(m*n)
    /*
    public static boolean searchMatrix(int[][] matrix, int target){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==target) return true;
            }
        }
        return false;
    }*/


    //Below is  binary Search
    public static boolean searchMatrix(int[][] matrix, int target){
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows*cols-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            int row = mid/ cols;
            int col = mid%cols;
            if(target==matrix[row][col]) return true;
            else {
                if (target > matrix[row][col]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
