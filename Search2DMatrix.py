## Problem1 
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1
        while low <= high:
            mid = low + (high - low) // 2
            row = mid // n
            col = mid % n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False        
#treat 2d matrix as 1d array and perform binarysearch
#time complexity O(log(m*n))
#space complexity O(1)