# Time Complexity : O(log(mn)) where m is the number of rows and n is the number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Flattening the 2D matrix into a 1D array - remember the formula for finding row and column indexes.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)    # num of rows
        n = len(matrix[0]) # num of cols
        low = 0
        high = (m * n) - 1
        
        while low <= high:
            mid = low + (high-low)//2

            row = mid // n
            col = mid % n
            if matrix[row][col] == target:
                return True
            if target > matrix[row][col]:
                low = mid + 1
            else:
                high = mid - 1

        return False