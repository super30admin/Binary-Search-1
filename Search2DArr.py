# // Time Complexity : O(log mn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        n = len(matrix[0])
        start = 0
        end = (m * n) - 1

        while start <= end:
            mid = (start + end) // 2
            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            if matrix[row][col] < target:
                start = mid + 1
            else:
                end = mid - 1

        return False
