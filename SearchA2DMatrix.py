'''
Binary-Search-1

Problem1

Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool: # type: ignore
        if matrix == None or len(matrix) == 0:
            return False

        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m*n - 1

        while low <= high:
            mid = low + (high-low) // 2
            row = mid//n
            col = mid % n

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid+1
            else:
                high = mid - 1

        return False            
