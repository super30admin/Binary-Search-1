class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // checking the edge cases for null matrix or length = 0
        // TC = O(logn) - Dividing the search space by half(B.S)
        //SC  = O(1)
        if(matrix == null || matrix.length == 0)
        {
            return false;
        }
        
        int a = matrix.length, b = matrix[0].length;
        int low = 0, high = a*b -1;
        
        // Treating it as a flattened sorted array and performing the standard Binary Search
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int row = mid/b;
            int col = mid%b;
            
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                high = mid -1;
            else
                low = mid+1;
        }
        return false;
        
    }
}