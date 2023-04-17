# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False

        m = len(matrix)  # Rows
        n = len(matrix[0])  # Columns
        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            r = mid // n  # Row
            c = mid % n  # Column

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False


if __name__ == "__main__":
    s = Solution()
    print(s.searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))
