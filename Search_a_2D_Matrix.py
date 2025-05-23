"""
# Time Complexity :
- O(log(m * n)), where m = number of rows, n = number of columns

# Space Complexity :
- O(1), no extra space used

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, (m * n) - 1

        while left <= right:
            mid = left + (right - left) // 2
            mid_val = matrix[mid // n][mid % n]

            if mid_val == target:
                return True
            elif mid_val < target:
                left = mid + 1
            else:
                right = mid - 1

        return False
