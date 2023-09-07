class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        int mid,row,col;
        while(low<=high){
            mid=low+(high-low)/2;
            row= mid/n;
            col= mid%n;
            if(target==matrix[row][col]){
                return true;
            }
            else if(target<matrix[row][col]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example matrix
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target1 = 5;
        int target2 = 20;

        boolean result1 = solution.searchMatrix(matrix, target1);
        boolean result2 = solution.searchMatrix(matrix, target2);

        System.out.println("Search for target1 (5): " + result1); // Should print true
        System.out.println("Search for target2 (20): " + result2); // Should print false
    }
}
