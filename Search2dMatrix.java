//Time Complexity: O(log(mn))
//Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int low = 0;
        int high = r*c-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/c;
            int col = mid%c;
            
            if(matrix[row][col] == target){
                return true;
            }else if(target < matrix[row][col]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}