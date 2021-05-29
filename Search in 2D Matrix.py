# Space Complexity : O(1)
# Time Complexity : O(log N)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        selected_row = 0
        row = len(matrix)
        col = len(matrix[0])
        row_low, row_high = 0, row - 1
        print(row_low, row_high)

        if row == 1 and col == 1:
            return target in matrix[0]

        while row_low < row_high:
            mid = (row_low + row_high) // 2

            if target >= matrix[mid][0] and target <= matrix[mid][-1]:
                selected_row = mid
                break;

            if target > matrix[mid][0]:
                row_low = mid + 1
                selected_row = row_low

            if target < matrix[mid][0]:
                row_high = mid - 1
                selected_row = row_high

        # found the row at which we need to search - row_low and row_high should be equal now
        # now need to search columns

        col_low, col_high = 0, col - 1

        while col_low <= col_high:
            mid = (col_low + col_high) // 2
            print(col_low, col_high, mid, row_low)
            if target == matrix[selected_row][mid]:
                return True

            if target > matrix[selected_row][mid]:
                col_low = mid + 1

            if target < matrix[selected_row][mid]:
                col_high = mid - 1

        return False
