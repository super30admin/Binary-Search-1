# Time Complexity : O(log(mn)), where m = Number of rows and n = Number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False

        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m * n - 1

        while (low <= high):

            mid = low + (high - low) // 2

            row = mid // n
            col = mid % n

            mid_element = matrix[row][col]

            if target == mid_element:
                return True

            elif target < mid_element:
                high = mid - 1

            else:
                low = mid + 1

        return False
