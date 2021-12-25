'''
TC: O(log(m + n))
SC: O(1)
Intuition: Start from top-right, eliminate rows and cols
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rowLen = len(matrix)
        if not rowLen:
            return -1
        colLen = len(matrix[0])
        
        starti, startj = 0, colLen - 1
        
        while starti < rowLen and startj > -1:
            if matrix[starti][startj] == target:
                return True
            if matrix[starti][startj] > target:
                startj -= 1
            if matrix[starti][startj] < target:
                starti += 1
        
        return False
        