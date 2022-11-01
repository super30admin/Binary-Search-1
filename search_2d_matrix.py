class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if not matrix:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        
        left = 0
        right = m * n - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            i = mid // n
            j = mid % n
            
            if matrix[i][j] == target:
                return True
            else:
                if matrix[i][j] > target:
                    right = mid - 1
                else:
                    left = mid + 1
        
        return False
