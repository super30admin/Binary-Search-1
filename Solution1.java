class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check the last element of the row and see if the target is in the given row
        // Check the first column of each row
        int row =searchCol(matrix, target);
        if(row == -1)
            return false;
        else
            return searchRow(matrix,row,target);

            
        }
    
    
    public boolean searchRow(int [][]matrix, int row, int target){
        //perform binary search
        int low = 0;
        int high = matrix[row].length;
        while(low <= high){
            int m = (low + high) /2;
            if(matrix[row][m] == target)
                return true;
            if(matrix[row][m] < target)
                high = m-1;
            else
                high = m+1;
        }
        return false;
        
    }
    
    public int searchCol(int [][]matrix, int target){
        //perform binary search
        int low = 0;
        int high = matrix.length;
        while(low <= high){
            
        int mid= (low + high)/2;

        if(matrix[mid][0] <= target && matrix[mid][matrix.length-1] >= target)
            return mid;
            
        
        if(matrix[mid][0] > target)
            high = mid - 1;
        else
            high = mid + 1;
    }
        return -1;

}

}
