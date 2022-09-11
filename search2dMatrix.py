# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l = 0
        m = len(matrix)
        n = len(matrix[0])
        if m*n == 0:
            return False
        r = m*n - 1
        while l <= r:
            mid = (l+r)//2
            row = mid//n
            col = mid % n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                l = mid + 1
            else:
                r = mid - 1
        return False
