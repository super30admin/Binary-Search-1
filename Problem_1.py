# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False
        x = len(matrix)
        y = len(matrix[0])
        r = (x * y)
        i = 0
        while i < r:
            midpt = ((i + r) // 2)
            m = (midpt // x)
            n = (midpt % y)
            if matrix[m][n] == target:
                return True
            if matrix[m][n] < target:
                i = (midpt + 1)
            else:
                r = midpt
        return False