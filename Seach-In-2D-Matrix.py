# Time Complexity - O(logn)
# Space Complexity - O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) == 0:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        
        low, high = 0, m*n-1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            r = mid // n
            c = mid % n
            
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False