# Time Complexity : O(logn)
# Space Complexity : O(1)  as not using any extra space doing it in place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
#I am using binary search to find the target in the 2D matrix. I treat the 2D matrix as a 1D array by taking the low as 0
# and high as the last index of the matrix. By this I find the mid of the array and then use that to find the row and column
# indices in the original 2D matrix. Then I compare with the mid and start elementing the search space accordingly. If I find the target, I return True else return False

from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix)
        m = len(matrix[0])
        low = 0
        high = m * n -1
        while low <= high:
            mid = low  + (high - low)// 2
            row = mid//m
            col = mid % m
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
        