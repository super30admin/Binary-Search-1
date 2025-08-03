from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        rows = len(matrix)
        cols = len(matrix[0])
        left, right = 0, rows * cols - 1

        while left <= right:
            mid = (left + right) // 2
            mid_value = matrix[mid // cols][mid % cols]  # Convert 1D index to 2D

            if mid_value == target:
                return True
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1

        return False

matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]
target = 3

sol = Solution()
print(sol.searchMatrix(matrix, target)) 
# Time Complexity:
#   O(log (m * n)) where m is the number of rows and n is the number of columns
#   This is because we treat the 2D matrix as a flattened sorted array,
#   and perform standard binary search.

# Space Complexity:
#   O(1) — only a few variables are used (left, right, mid)

# Did this code successfully run on Leetcode: Yes, 74 (Search a 2D Matrix)

# Any problem you faced while coding this:
#   Yes — had to learn how to convert a 1D index into 2D matrix coordinates using:
#         row = mid // cols, col = mid % cols
#   This allows binary search on a 2D matrix without flattening it manually.

