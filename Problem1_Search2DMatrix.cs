// Approach 1: each row is sorted - if we compare target with last element in each row and figure out the desired row, then binary search that row; time complexity is O(m + log n)
// Current Approach: Visualize the 2D matrix as 1D array and perform binary search
// Time Complexity: O(log mn) where m is the number of rows, n is the number of cols
// Space Complexity: O(1)

public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int rows = matrix.Length, cols = matrix[0].Length;
        
        int start = 0, end = rows*cols-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            int r = mid/cols;
            int c = mid%cols;
            
            if(matrix[r][c] == target)
                return true;
            else if(target < matrix[r][c])
                end = mid-1;
            else
                start = mid+1;
        }
        
        return false;
    }
}