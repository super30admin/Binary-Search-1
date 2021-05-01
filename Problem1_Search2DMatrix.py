# Time Complexity: O(log mn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

# Solution:
"""
1. Consider the 2D matrix as a single 1D array.
2. Perform binary search for the array and return true if the target is found.
"""

class Solution:
    def search_matrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False

        m = len(matrix)
        n = len(matrix[0])

        # Set the lower and higher bounds for binary search considering the length of the 2D array as a 1D array.
        low = 0
        high = m * n - 1

        # Perform binary search
        while low <= high:
            mid = low + (high - low) // 2
            r = mid // n
            c = mid % n

            if target == matrix[r][c]:
                return True

            elif target < matrix[r][c]:
                high = mid - 1

            else:
                low = mid + 1

        return False

