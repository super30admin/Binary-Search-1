from typing import List
'''
Time Complexity: O(log(m*n))
Space Complexity: O(1)
'''


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False

        m = len(matrix)  # Get the number of rows in the matrix
        n = len(matrix[0])  # Get the number of columns in the matrix

        low = 0  # Initialize the lower bound of the search range
        high = m * n - 1  # Initialize the upper bound of the search range

        while low <= high:
            mid = low + (high - low) // 2  # Calculate the middle index

            row = mid // n  # Calculate the row index from the middle index
            col = mid % n  # Calculate the column index from the middle index

            # If the element at the middle index is the target, return True
            if matrix[row][col] == target:
                return True

            if matrix[row][col] > target:
                high = mid - 1  # If the element is greater than the target, update the high to search the left side
            else:
                low = mid + 1  # If the element is less than the target, update the low to search the right side

        return False  # If the target is not found, return False
