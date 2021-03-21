# Time Complexity : O(log n) where n is the size input matrix and
#           n = r*c where r and c are the rows and columns of
#           matrix respectively
#
# Space Complexity : O(n) where n = r*c (rows * columns)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        high = (len(matrix) * len(matrix[0])) - 1

        while low <= high:
            mid = low + (high - low) // 2
            rows = mid // len(matrix[0])
            cols = mid % len(matrix[0])
            if matrix[rows][cols] == target:
                return True
            elif matrix[rows][cols] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
