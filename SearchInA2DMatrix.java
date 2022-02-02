/*

Time Complexity : Binary search complexity O(log(rows*cols))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
1. As the given input row is sorted from left to right, I thought to apply binary search on the matrix
2. for binary search left and right pointer is needed, so I defined left and right pointers for the matrix
3. Calculation for mid or pivot index in the matrix
4. Based on the value we have corresponding to the mid index, I am shifting my right and left pointer in the matrix

 */
public class SearchInA2DMatrix {
    public static boolean searchInA2DMatrix(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 0){
            return false;
        }
        int left = 0;
        int right = rows*cols-1;
        int matrixPivot;

        while(left<= right){
            int mid = left + (right-left)/2;
            matrixPivot = matrix[mid/cols][mid%cols];
            if(target == matrixPivot){
                return true;
            }else if(target<matrixPivot){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] grid  = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        // Should return true
        System.out.println(searchInA2DMatrix(grid, 8));

        // Should return false
        System.out.println(searchInA2DMatrix(grid, 21));
    }
}
