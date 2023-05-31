# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        Convert 2d matrix on 1d and do binary search.
        Find corresponding position of number in 2D array to compare.
        """
        total_rows = len(matrix)
        total_cols = len(matrix[0])
        h = (total_rows * total_cols) - 1
        l = 0
        while (l <= h):
            mid = l + (h - l) // 2
            row = mid // total_cols
            col = mid % total_cols
            if target == matrix[row][col]:
                return True
            elif target > matrix[row][col]:
                l = mid + 1
            else:
                h = mid - 1