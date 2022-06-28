# Time Complexity : 
#  O(log(n*m)) = O(log m) + O(log n)
# Space Complexity : O(1) No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#  Imagine a flattened array as the rows and columns are sorted
# The approach to image that the array is sorted works very well
# and gives the complexity
from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return
        # rows
        m = len(matrix)
        # Columns
        n = len(matrix[0])
        low = 0
        high = m*n -1
        # Binary Search
        while low <= high:
            mid = low + (high - low)//2
            row = mid // n
            col = mid % n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
s = Solution().searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3)
print(s)
