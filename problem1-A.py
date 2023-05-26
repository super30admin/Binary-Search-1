#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Initially used binary search to first find where the target lies in terms of the row position as we are clearly given the lower and uuper bounds. Next I again used binary search to further find which column the target can be located.


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        row_start, row_end = 0, len(matrix)-1
        while row_start <= row_end:
            row = (row_start + row_end) // 2
            if target > matrix[row][-1]:
                row_start = row + 1
            elif target < matrix[row][0]:
                row_end = row - 1
            else:
                break

        if row_start > row_end:
            return False

        row = (row_start + row_end) // 2
        col_start, col_end = 0, len(matrix[0])-1
        while col_start <= col_end:
            col = (col_start + col_end) // 2
            if target > matrix[row][col]:
                col_start = col + 1
            elif target < matrix[row][col]:
                col_end = col - 1
            else:
                return True
        
        return False