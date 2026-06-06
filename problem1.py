# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# Time Complexity O(log(m*n)) m*n elements
# Space Complexity O(1)


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)  # rows [[],[],[]]
        n = len(matrix[0])  # columns
        low = 0
        high = (m * n) - 1
        while low <= high:
            mid = (low + high) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            if matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
