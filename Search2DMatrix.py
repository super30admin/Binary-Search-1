"""
74.Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the
following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Approach --
- Find length of row and column
- find mid and find mid element value
- run a binary search and compare target to mid_val
- if low, search the left. if high, search the right

Time complexity - O(log mn)
Space complexity - O(1)
"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])

        low = 0
        high = (row*col) - 1

        if matrix is None or row == 0:
            return

        while low <= high:
            # calculate mid
            #(high+low)/2 is not used here
            # avoids integer overflow
            mid = low + (high-low) // 2

            # calculate mid_val
            #first division helps find the row and the mod calculation helps find the element in row
            mid_val = matrix[mid//col][mid%col]

            if target == mid_val:
                return True
            elif target < mid_val:
                high = mid - 1
            else:
                low = mid + 1

obj = Solution.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3)
print(obj)