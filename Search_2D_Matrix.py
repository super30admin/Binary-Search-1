# Time Complexity : O(log(m*n)) - binary search on rows and columns.
# Space Complexity : O(1) - storing only variables.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Trouble calculating rows and columns part.

#Your code here along with comments explaining your approach in three sentences only
#Converting 2d matric to imagneary 1d array.
#calculating r,c using mid to apply binary search and get return value.

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        m = len(matrix)
        n = len(matrix[0])
        l = 0
        h = m * n - 1

        while l <= h:
            mid = l + (h - l) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                h = mid - 1
            else:
                l = mid + 1
        return False
