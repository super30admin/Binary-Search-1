#Time Complexity: O(log(m * n)) where m is number of rows and n is number of columns.
#Space Complexity: O(1)
#if matrix == None or matrix.length == 0)
#This algorithm treats a 2D matrix as a flattened 1D sorted array and applies binary search.By converting the 1D index to 2D coordinates, we efficiently locate the target without searching row by row.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Edge case: if matrix is empty or first row is empty
        if not matrix or not matrix[0]: #if matrix == None or length(matrix) == 0)
            return False

        # Get number of rows (m) and columns (n)
        m, n = len(matrix), len(matrix[0])

        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2

            # Convert the 1D index to 2D indices: row (r) and column (c)
            r = mid//n
            c = mid%n

            # Check the value at matrix[r][c]
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1  # Search in the left half
            else:
                low = mid + 1   # Search in the right half

        # Target not found in matrix
        return False