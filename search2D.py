# Time Complexity: O(logmn):
# Space Complexity: O(1)

# We imagine the 2D array as a 1D array first, and do the Binary search.

# Once we imagine, we need to arrive at the 2D co-ordinates from the 1-D number.

# The row number is dictated by dividing by NUmber of columns and the column number by taking the Modulus


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            r = mid // n
            c = mid % n

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False
