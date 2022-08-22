# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or matrix == None:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low,high=0,(n*m)-1
        while low<=high:
            mid = low + (high-low)//2
            r = mid // n 
            c = mid % n 
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
    
# Time Complexity -> log(n)
# Space Complexity -> o(1)