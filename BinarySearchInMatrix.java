/**

M = 3 N = 4
00 01 02 03
10 11 12 13
20 21 22 23

Consider it a single array
initialize the low = 0 and high = lastIndex(m*n-1)
calculate the middle = low + (high-low)/2;

calculate the row and the column from that middle index
to find the value in the matrix

Time Complexity : O(logN)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class BinarySearchInMatrix 
{
    
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        
        if(matrix == null || matrix.length == 0)
            return false;
        
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        
        int elementCount = rowCount * colCount;
        int low = 0;
        int high = elementCount -1;
        
        while(low <=high)
        {
            int middle = low + (high-low)/2;
            int rowIndex = middle / colCount;
            int colIndex = middle % colCount;
            
            int middleValue = matrix[rowIndex][colIndex];
            
            if(middleValue == target)
            {
                return true;
            }
            else if(target > middleValue)
            {
                low = middle + 1;
            }
            else
            {
                high = middle -1;
            }
            
        }
        
        return false;
        
    }


    public boolean searchValue(int[][] matrix, int target)
    {
        if(matrix == null || matrix.length ==0)
            return false;
        
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        boolean rangeFound = false;
        int rowIndex = -1;

        for(int i = 0; i < rowCount; i++)
        {
            if( matrix[i][0] <= target && matrix[i][colCount-1] >= target)
            {
                rangeFound = true;
                rowIndex = i;
                break;
            }
        }

        if(!rangeFound)
            return false;

        int low = 0;
        int high = colCount -1;

        while( low <= high )
        {
            int mid = low + (high - low)/2;
            int midVal = matrix[rowIndex][mid];

            if(target == midVal)
                return true;
            else if(target > midVal)
                low = mid + 1;
            else
                high = mid -1;
        }
    
        return false;
    }
    
    
}