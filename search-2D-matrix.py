# Complexity: O(m+n)

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row, col = 0, len(matrix[0]) - 1
        while row < len(matrix) and col >= 0:
            element = matrix[row][col]
            if element == target: return True
            elif element > target: col -= 1
            elif element < target: row += 1
        return False
        