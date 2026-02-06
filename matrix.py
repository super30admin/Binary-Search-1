# Time Complexity : O(log m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Treats the 2D matrix as a single sorted array and applies binary search on the virtual index.
# Each check maps the 1D index back to a 2D (row, col) position.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        num_rows, num_cols = len(matrix), len(matrix[0])

        low, high = 0, num_rows * num_cols - 1

        while low <= high:
            mid = low + ((high - low) // 2)

            row = mid // num_cols
            col = mid % num_cols

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False
