class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)
            return false;
        int col = matrix[0].length;

        for(int i=0; i<row; i++){
            int col_index = binary_search(matrix[i], target);
            if(col_index == -1)
                continue;
            else
                return true;
        }
        return false;
    }
    
    public int binary_search(int[] nums, int target) {
        int low = 0, high = nums.length - 1; 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
            if (nums[mid] == target) 
                return mid; 
            if (nums[mid] < target) 
                low = mid + 1;   
            else
                high = mid - 1; 
        } 
        return -1; 
    }
    
}