"""
I implemented the solution using the technique discussed in the session. I treated the 2D matrix as a 1D array and used binary search to find the target. For each midpoint, I calculated the corresponding row and column indices to access the correct element in the matrix.
Time Complexity: O(log mn)
Space Complexity: O(1)
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False
        rows = len(matrix)
        columns = len(matrix[0])
        low = 0
        high = rows * columns - 1
        while(low <= high):
            mid = low + (high - low) // 2
            row_index = mid // columns
            column_index = mid % columns
            if matrix[row_index][column_index] == target:
                return True
            elif matrix[row_index][column_index] < target:
                low = mid + 1
            else:
                high = mid -1
        return False


        