# Time Complexity : O(log(m * n)) where m = number of rows, n = number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # edge case: empty matrix or empty rows
        if not matrix or not matrix[0]:
            return False

        m = len(matrix)
        n = len(matrix[0])

        l = 0
        r = m * n - 1

        # binary search
        while l <= r:
            mid = (l+r) // 2
            row = mid // n
            col = mid % n
            mid_val = matrix[row][col]

            if mid_val == target:
                return True
            elif mid_val > target:
                r = mid - 1
            else:
                l = mid + 1
        return False
    
if __name__ == "__main__":
    sol = Solution()

    matrix = [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 60]
    ]

    target1 = 3
    print(sol.searchMatrix(matrix, target1))

    target2 = 13
    print(sol.searchMatrix(matrix, target2))