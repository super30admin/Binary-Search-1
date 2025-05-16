# Time Complexity :
#  O(log(m * n)) — where m is the number of rows and n is the number of columns.
# Space Complexity : 
# O(1) — we’re only using a few variables, no extra space.
# Did this code successfully run on Leetcode :
#  Yes

# Approach
# Since each row is sorted and the first number of each row is greater than the last of the previous row,
# we can treat the 2D matrix as one long sorted 1D array. We apply binary search on this virtual array, 
# converting the mid index into row and column coordinates to access the actual matrix value.


from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        rows, cols = len(matrix), len(matrix[0])
        low, high = 0, rows * cols - 1

        while low <= high:
            mid = (low + high) // 2
            row, col = mid // cols, mid % cols
            mid_val = matrix[row][col]
            
            if mid_val == target:
                return True
            elif mid_val < target:
                low = mid + 1
            else:
                high = mid - 1

        return False
