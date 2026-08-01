# Time Complexity: O(log(m * n))
# Space Complexity: O(1)
# Did this code successfully run on LeetCode: Yes

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m, n = len(matrix), len(matrix[0])
        l, h = 0, m * n - 1
        while l <= h:
            mid = (l + h) // 2
            r, c = mid // n, mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                l = mid + 1
            else:
                h = mid - 1
        return False
        