// Time Complexity O(logmn)
// Space Complexity O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int start = 0;
        int end = r*c - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            int i = mid/c;
            int j = mid%c;
            
            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j] < target ) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return false;
    }
}
