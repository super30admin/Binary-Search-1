//Time Complexity: O(logN)
//Space Complexity: O(1)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
//Memory Usage: 38.6 MB, less than 30.18% of Java online submissions for Search a 2D Matrix.
// No problems faced

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = convert2dTo1d(0, 0, n);
        int high = convert2dTo1d(m-1, n-1, n);
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int[] rowCol = convert1dTo2d(mid, n);
            
            int value = matrix[rowCol[0]][rowCol[1]];
            
            if(value == target){
                return true;
            }else if(value < target){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
    
    private int convert2dTo1d(int row, int col, int width){
        return row * width + col;
    }
    
    private int[] convert1dTo2d(int index, int width){
        int[] rowCol = new int[2];
        rowCol[0] = index / width;
        rowCol[1] = index % width;
        return rowCol;
    }
}
