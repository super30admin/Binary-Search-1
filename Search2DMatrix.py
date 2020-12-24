# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#Brute Force is to traverse all the element in Sorted Matrix so the time complexity is O(N).
# Using Binary Search, the search space is reduced to O(logN)


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return None
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = (m * n) - 1
        while left <= right:
            mid = left + (right - left) // 2
            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                left = mid + 1
            else:
                right = mid - 1

        return False
