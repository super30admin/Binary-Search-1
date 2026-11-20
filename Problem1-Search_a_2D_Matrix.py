# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        ROWS = len(matrix)
        COLS = len(matrix[0])

        l = 0
        r = (ROWS * COLS) - 1

        while l <= r:
            mid = (l + r) // 2
            row = mid // COLS
            col = mid % COLS

            if matrix[row][col] == target:
                return True

            elif matrix[row][col] < target:
                l = mid + 1

            else:
                r = mid - 1
        return False