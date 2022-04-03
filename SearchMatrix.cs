// Time Complexity : O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, debugged and found that i was calculating row and column wrong.


// Your code here along with comments explaining your approach
//treat the whole matrix as signgle 1D array without copying into any addtional array, if we use addtional array, tat will increaes Time and space complexity.
//then apply binary search to get middle, once we have middle, we get the row and column for that middle element
//and then do regular binary search operation
public bool SearchMatrix(int[][] matrix, int target) {
        
    if(matrix == null || matrix.Length == 0)
        return false;
    
    int m = matrix.Length;
    int n = matrix[0].Length;
    int low = 0;
    int high = m * n - 1;
    
    while(low <= high)
    {
        //once we have middle, we get the row and column for the middle element
        int mid = low + (high - low)/2;
        int row  = mid / n;
        int col = mid % n;
        
        if(target == matrix[row][col])
            return true;
        
        if(target < matrix[row][col])
            high = mid - 1;
        else
            low = mid + 1;
    }
    
    return false;
}