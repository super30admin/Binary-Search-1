'''
    Time Complexity:
        O(log(mn))

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Do a binary search to find the correct row.
        If the row == -1:
            return False
        Else, do a binary search on the row to find the right cell.
        If the cell == -1: return False, else return True
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False

        row = self.find_row(matrix, target)
        if row == -1:
            return False

        col = self.find_in_row(matrix, target, row)

        return False if col == -1 else True

    def find_row(self, matrix, target):
        left = 0
        right = len(matrix) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if target < matrix[mid][0]:
                right = mid - 1
            elif target > matrix[mid][-1]:
                left = mid + 1
            else:
                return mid

        return -1

    def find_in_row(self, matrix, target, row):
        left = 0
        right = len(matrix[row]) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if target < matrix[row][mid]:
                right = mid - 1
            elif target > matrix[row][mid]:
                left = mid + 1
            else:
                return mid

        return -1
