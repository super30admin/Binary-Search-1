#  Time Complexity : O(log (m*n)) where m and n are the dimensions of the matrix
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 

#Assume the 2D matrix as a larger 1D matrix of size m*n where m and n is the length of the 2D matrix and run Binary Search on the array.  
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) -1
        while (low <= high):
            mid = (low + high) // 2

            # n elements in each row. To get row number we divide. To get the column from 0 to n - 1, we use mod. 
            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
