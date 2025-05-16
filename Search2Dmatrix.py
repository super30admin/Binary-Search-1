"""
Time Complexity: O(log (mn))
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# Performs binary search by treating the 2D matrix as a flat 1D array using index mapping.
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
        if m == 0:
            return False
        n = len(matrix[0])
        high = m * n - 1
        while (low<= high) :
            mid = low + (high-low)//2
            row_idx = mid//n
            col_idx = mid%n

            if(matrix[row_idx][col_idx] == target):
                return True
            if (matrix[row_idx][col_idx] < target):
                low = mid + 1
            else:
                high = mid -1
        return False