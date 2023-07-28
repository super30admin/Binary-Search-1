'''
Approach:
Number of rows * columns is length of the matrix and mid is calculated accordingly.
we need to retrieve the row number and column number for the calculated mid
and perform binary search on the elements with the help of retrieved indices and
return true when we find the target element.
'''


# Time Complexity : O(log m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #base case
        if not matrix or len(matrix) == 0:
            return False

        low = 0
        rows = len(matrix)
        cols = len(matrix[0])
        high = (rows * cols) - 1

        while(low <= high):
            mid = low + (high-low)//2  # To avoid integer overflow
            # gets the row number and column number at which the mid is present
            row = mid//cols
            col = mid%cols

            # when the target is mid
            if matrix[row][col] == target:
                return True
            '''
            when mid is less than target that means we need to search right side of the array 
            i.e. update low else we need to search the right side of the array
            i.e. update high
            '''

            elif matrix[row][col] < target:
                low = mid + 1

            else:
                high = mid - 1

        return False