# Problem 1 : Search a 2D Matrix
# Time Complexity : O(log (m*n)) where m is the size of row and n is the size of the column of matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach in three sentences only
from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # edge case where matrix is None or length is 0 then return false
        if matrix is None or len(matrix) == 0: return False
        # get the length of the row and column of matrix
        rowLength = len(matrix)
        colLength = len(matrix[0])
        # set the low to 0 and high to last element ie. (rowLength * colLength) - 1
        low = 0
        high = (rowLength * colLength) - 1

        # loop till low <= high
        while (low <= high):
            # find middle element 
            middle = low + (high - low) // 2
            # get the row index and column index from the middle value and column length
            row = int(middle / colLength)
            col = int(middle % colLength)
            # check if the element at row and col position of matrix is equal to target
            if matrix[row][col] == target:
                # if it equal then return True
                return True
            # if target is less than matrix value then set high to mid - 1 ie search in left part
            elif(matrix[row][col] > target):
                high = middle - 1
            # if target is greater than matrix value then set low to mid + 1 ie search in right part
            else:
                low = middle + 1
        # if the target is not found at all then return false
        return False