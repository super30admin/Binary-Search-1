/*This approach for solving first finds the median of the
array input, since it is sorted left to right and top to
bottom. It checks if the target is greater or lesser than 
the median value, and subdivides the array into halves
recursively. This algorithm runs in time O(2log(n))

Problems with this program: It refuses to compile on leetode,
saying that non void funtion which is median find does not 
return a value in all control paths.

Did this code run on leetcode?: No

*/

class Solution {
    
public:
    //T(n) = O(log(n)); S(n) = 
    bool binarySearch(vector<int>& matrix, int left, int right, int target)
    {
        if (right >= left) 
        {
            int mid = left + (right - left) / 2;
 
            if (matrix[mid] == target)
                return true;
 

            if (matrix[mid] > target)
                return binarySearch(matrix, left, mid - 1, target);
 
            return binarySearch(matrix, mid + 1, right, target);
        }
 
        return false;
    }
    /*function to calculate median. Since we know array is sorted, we can take a good assumption that median 
    is somewhere at the matrix[i/2][j/2] position*/
    //T(n) = O(log(n)) S(n) = O(n)
    bool medianFind(vector<vector<int>>& matrix, int target, int rowStart, int rowEnd, int columnStart, int columnEnd)
    {
        int medianRow = (rowStart + rowEnd) / 2;
        int medianColumn = (columnStart + columnEnd) / 2;
        int median = matrix[medianRow][medianColumn];
        
        //We check this condition for the base case, which is when there is only one row. 
        if(rowStart < rowEnd)
        {
            if(median == target)
                return true;
        
            if (median > target)
            {   //We do binary search to search the subarray that is less than median on the row of the median, before we divide the array
                if(binarySearch(matrix[medianRow], columnStart, medianColumn-1, target) ==  true)
                    return true;
                else
                    medianFind(matrix, target, rowStart, medianRow-1, columnStart, columnEnd);
            }
        
            if (median < target)
            {   //We do binary search to search the subarray that is greater than median on the row of the median, before we divide the array
                if(binarySearch(matrix[medianRow], medianColumn+1, columnEnd, target) == true)
                    return true;
                else
                    medianFind(matrix, target, medianRow+1, rowEnd, columnStart, columnEnd);
            }
        }    
        
        else
        {
            if (median == target)
                return true;
        
            else if(median > target)
            {
                if(binarySearch(matrix[medianRow], columnStart, medianColumn-1, target) == true)
                    return true;
                return false;
            }
        
            else if(median < target)
            {
                if(binarySearch(matrix[medianRow], medianColumn+1, columnEnd, target) == true)
                    return true;
                return false;
            }
        }
    }
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) 
    {
        int rows = matrix.size();
        int columns = matrix[0].size();
        
        if(medianFind(matrix, target, 0, rows-1, 0, columns-1) == true)
            return true;
        return false;
    }
};