# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0:
            return False
        low = 0
        rows = len(matrix)
        cols = len(matrix[0])
        high = (rows*cols) - 1
        
        while (low<=high):
            mid = low + (high-low)/2
            rowIndex = mid/cols
            colsIndex = mid%cols
            element = matrix[rowIndex][colsIndex]
            if target == element:
                return True
            elif element<target:
                low = mid + 1
            else:
                high = mid -1
        return False
            