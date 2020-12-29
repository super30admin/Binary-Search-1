"""Python implementation of a number search in a 2D array
Time complexity : O(logN) where N is the number of elements in the array
Space Complexity : O(1)
Did the program run for all test cases on leetcode ? : Yes
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return 0
        
        n = len(matrix[0])
        m = len(matrix)
        low = 0
        high = m*n - 1
          
        while low <= high:
            mid = low + (high-low)//2
            r = mid // n
            c = mid % n
            if target == matrix[r][c]:
                return True
            elif target < matrix[r][c]:
                high = mid - 1
            else:
                low = mid + 1
        return False               