class Solution:
    """
    Time Complexity: O(log(m*n)) where m is the number of rows and n is the number of columns.
                                 Binary search is perform on all the elements of an array.
    Space Complexity: O(1)
    
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No

    Your code here along with comments explaining your approach:

    Different Appraoches:
    1. Brute Force: Perform Linear search along all the elements. 
         Time Complexity: O(m * n)
         index = 0
         for index in searchMatrix.length():
            if searchMatrix[index] == target:
                return True
         return False

    2. 
    - First Perfrom Binary Search along the last column and 
    - Once decided the row in which element is present agaiin perfrom the Binary search along the row
        Time Comlexity: O((log m)+ (log n))
        low = [0][searchMatrix.length() - 1]
        high = searchMatrix.length() - 1
        mid = 0
        while(low <= high):
            mid = low + (high - low ) // 2
            rowIndex = mid // numberOfColumns //as the nuber of columns decide how many rows will be present in an matrix
            colIndex = mid % numberOfColumns

            if searchMatrix[rowIndex][colIndex] == target:
                return True
            if target < searchMatrix[rowIndex][colIndex]:
                high = mid -1
            else:
                low = mid + 1
        
        //Perform Binary search on the row. row number id mid
        return False 

    
    3. 
    - Perform the linear search along the column and decide in which row target is located
    - Perfrom linear search again on that row
        Time Complexity: m + n where m is the number of columns and n is the number of rows
    
    4. 
    - consider the whole 2D array as one 1D array
    - Calulate the number of rows and columns
    - low = 0
      high = (n * m) - 1
    - Perform the Binary search
    - Calulate the rowIndex and colIndex as follows:
        rowIndex = mid // numberOfColumns
        colIndex = mid % numberOfColumns

    """

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        numberOfRows = len(matrix)
        numberOfColumns = len(matrix[0])

        low = 0
        high = (numberOfRows*numberOfColumns) -1 

        while(low <= high):
            mid = low + (high - low) // 2

            #Get the row index and column index
            rowIndex = mid // numberOfColumns #As the nuber of columns decide how many rows will be present in an matrix
            colIndex = mid % numberOfColumns

            if matrix[rowIndex][colIndex] == target:
                return True
            if target < matrix[rowIndex][colIndex]:
                high = mid -1
            else:
                low = mid + 1
        return False 