# Time Complexity : O(log m + log n)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

from typing import List


class Solution:
    # finding the row containing the target value
    def bs_row(self, matrix, low, high, x):
        if high >= low:
            mid = (high + low) // 2
            if matrix[mid][0] == x:
                return mid
            elif high - mid == 1 and matrix[mid][0] < x and matrix[high][0] > x:
                return mid
            elif x >= matrix[high][0]:
                return high
            elif matrix[mid][0] > x:
                return self.bs_row(matrix, low, mid-1, x)
            else:
                return self.bs_row(matrix, mid, high, x)
        else:
            return -1

    # finding the target value in that row
    def bs_col(self, matrix, low, high, row, x):
        if high >= low:
            mid = (high + low) // 2
            if matrix[row][mid] == x:
                return True
            elif matrix[row][mid] > x:
                return self.bs_col(matrix, low, mid - 1, row, x)
            else:
                return self.bs_col(matrix, mid + 1, high, row, x)
        else:
            return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        self.row = len(matrix)
        self.col = len(matrix[0])
        find_row = self.bs_row(matrix, 0, self.row-1, target)
        if find_row == -1:
            return False
        else:
            find_col = self.bs_col(matrix, 0, self.col-1, find_row, target)
            if find_col == True:
                return True
            else:
                return False
