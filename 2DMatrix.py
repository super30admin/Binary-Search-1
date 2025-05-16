# Time Complexity: O(log(m*n)), m is the size of rows, n is the size of columns in 2D Matrix
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes


# Your code here along with comments explaining your approach in three sentences only
"""
I have considered 2D Matrix as single array and applied binary search
"""


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        low = 0
        m = len(matrix)
        n = len(matrix[0])
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) / 2
            row_index = mid / n
            col_index = mid % n

            if matrix[row_index][col_index] == target:
                return True
            elif matrix[row_index][col_index] > target:
                high = mid -1
            else:
                low = mid + 1
        
        return False