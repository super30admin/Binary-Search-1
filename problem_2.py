""" Search in 2D Matrix """
# Time Complexity : O(Log(m*n)) where m: #rows and n: #cols
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
#   Initially, I did binary search on 1st column to get a row,
#   and then on that row again binary Search.

class Solution:
        
    def searchMatrix(self, matrix: 'list[list[int]]', target: int) -> bool:
        num_rows = len(matrix)
        num_cols = len(matrix[0])
        
        low = 0
        high = num_rows * num_cols - 1
        
        while low <= high:
            mid = int(low + (high-low)/2)
            r = int(mid / num_cols)
            c = int (mid % num_cols)
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False