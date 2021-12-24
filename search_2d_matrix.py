# Time complexity O(logm + logn)
# Space complexity O (1)
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        start_vals = []
        for i in range(len(matrix)):
            start_vals.append(matrix[i][0])
        
        start = 0
        end = len(start_vals) - 1
        
        while (start <= end):
            mid = (start + end)//2 
            if start_vals[mid] == target:
                return True
            if start_vals[mid] < target :
                start = mid + 1
            elif start_vals[mid] > target:
                end = mid -1
        
        print(end)
        
        st = 0
        en = len(matrix[end]) -1
        
        while ( st <= en):
            m = ( st + en ) //2
            if matrix[end][m] == target:
                return True
            elif matrix[end][m] < target:
                st = m + 1
            elif matrix[end][m] > target:
                en = m - 1
        
        return False