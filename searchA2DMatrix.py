# Time Complexity : O(lgN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. with the approach I went, 
# I had to figure out how to translate 1D index to 2D(to get the rows/columns). 
# After seeing a pattern I was able to figure it out with a little bit of math.


# Your code here along with comments explaining your approach
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        Notes:
        want to use Binary search on 2D array.
        Want to think of it as 1D array. 
        left = 0 and the total number of elements in matrix is row*col. (row*col - 1 cause 0 based)
        1D : row|col : val
        0       0  0    1
        6       1  2    16  -> matrix[1][2] -> [1D/col][1D%col] -> 6/4 = 1 6%4 = 2
        7.      1  3    20                                      -> 7/4 = 1 7%4 = 3
        """
        if not matrix:
            return False
        
        left = 0 
        right = len(matrix) * len(matrix[0]) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            #need to get the mid value
            midVal = matrix[mid // len(matrix[0])][mid % len(matrix[0])]
            #found
            if target == midVal:
                return True 
            elif midVal < target:
                left = mid + 1
            else:
                right = mid - 1
                
        return False
                