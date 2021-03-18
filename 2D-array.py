# Time Complexity: O(log(mn))
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        l = 0
        h = m * n - 1
        while (l <= h):
            mid = l + (h - l) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                l = mid + 1
            else:
                h = mid - 1
        return False
        