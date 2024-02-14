class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        Approach :
            As rows and columns are sorted, and first integer of each row is greater than the
            last integer of previous row, we can consider this as a single sorted array, and
            apply Binary Search technique.

            We can find the total number of elements in the array using M * N where 
            M is number of rows and N is number of columns.

            We will find mid using (low + high)/2. Now we have to derive the row and column
            index using this mid value. We can achieve this using 
            row = mid // cols
            column = mid % cols

            We can move our high and low based on target value. and if at any point if value 
            matches with target we will return true or else false.  
    
            Time Complexity - O(log(M * N)) where M is number of rows and N is number of columns.
            Space Complexity - O(1)

        Alternate Approach :
            As rows are sorted, we can identify where our target lies based on starting and 
            ending value of row. Once we found a row in which our target lies, we can then apply
            binary search to find the result.

            We can find the target row, by applying binary search on first and last column of 
            the matrix.

            Note : We cannot apply binary on rows first and columns next based rows are connected,
            but columns are not connected.

            Time Complexity: O(log(N)) + O(log(M)) 
                             where N is number of columns and M is number of rows
            Space Complexity: O(1) 
        """
        rows = len(matrix)
        cols = len(matrix[0])
        low, high = 0, rows * cols - 1
        
        while(low <= high):
            mid = low + (high - low)//2
            cur_row = mid // cols
            cur_col = mid % cols

            if matrix[cur_row][cur_col] == target:
                return True
            elif matrix[cur_row][cur_col] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
