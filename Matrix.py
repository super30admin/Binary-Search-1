# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def searchMatrix(self, matrix, target):

        # Getting the row and column size
        row = len(matrix)
        column = 0
        if len(matrix) != 0:
            column = len(matrix[0])

        row_counter = 0

        # Searching linearly in the matrix for the given target
        while column >= 0 and row_counter < row:
            if matrix[row_counter][column - 1] == target:
                return True
            if matrix[row_counter][column - 1] > target:
                column -= 1
            else:
                row_counter += 1

        return False

        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
