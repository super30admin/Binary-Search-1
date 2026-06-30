from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])

        left, right = 0, rows * cols - 1

        while left <= right:
            mid = (left + right) // 2

            # Convert 1D index to 2D coordinates
            r = mid // cols
            c = mid % cols

            val = matrix[r][c]

            if val == target:
                return True
            elif val < target:
                left = mid + 1
            else:
                right = mid - 1

        return False