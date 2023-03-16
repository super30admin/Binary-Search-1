# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""Solved the problem by treating the matrix as a single dimensional array and getting the 
position of the mid element through floor division and modulo operators"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None and len(matrix)==0:
            return False
        
        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = (m*n)-1

        while low<=high:
            mid = (low+high)//2
            row,column = mid//n, mid%n

            if matrix[row][column] == target:
                return True
            elif matrix[row][column] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False