from typing import List

"""
Time Complexity -> O(log M +log N) where M is number of rows and N is number of columns
Space Complexity -> O(1), no extra space used
Used Binary search to find the correct row and then perform secondary binary search to find the
element in that row. Return False if it doesnt exist
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        l = 0
        h = ROWS - 1
        if target < matrix[0][0] or target > matrix[ROWS - 1][
            COLS - 1]:  # check if the element exists in the matrix or not
            return False
        while l <= h:
            mid_row = l + (h - l) // 2
            if matrix[mid_row][0] <= target <= matrix[mid_row][COLS - 1]:
                break
            elif target < matrix[mid_row][0]:
                h = mid_row - 1
            elif target > matrix[mid_row][COLS - 1]:
                l = mid_row + 1
        l = 0
        h = COLS - 1
        while l <= h:
            mid_col = l + (h - l) // 2
            if matrix[mid_row][mid_col] == target:
                return True
            elif target < matrix[mid_row][mid_col]:
                h = mid_col - 1
            elif target > matrix[mid_row][mid_col]:
                l = mid_col + 1
        return False
