# Time Complexity: O(log(m*n))
# Space Complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Consider the matrix as a single one d array
        # Since all rows and columns are sorted the imaginary one d array is also sorted if we traverse it one row at a time
        # Considering this we will apply binary search on this one d array
        numRows = len(matrix)
        if numRows < 1:
            return False
        numCols = len(matrix[0])
        start = 0
        end = (numRows * numCols) - 1 
        while start <= end:
            mid = start + ((end-start)//2)
            row = mid // numCols
            col = mid % numCols
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                start = mid + 1
            else:
                end = mid - 1
        return False