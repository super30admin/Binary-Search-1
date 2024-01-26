'''
Most optimized by determining the indexes using %COL and //COL
TC: O(logn)
SC: O(1)
'''
from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        i,j = 0, ROWS*COLS -1
        while i<=j:
            mid = (i+j)//2
            r, c = mid//COLS, mid%COLS
            if matrix[r][c] == target:
                return True
            if target < matrix[r][c]:
                j = mid-1
            else:
                i = mid+1
        return False

s = Solution()
print(s.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3))
print(s.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13))