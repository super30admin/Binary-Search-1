## Time Complexity: O(lgn)
## Space Compexity O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    
        n = len(matrix[0])
        lo, hi = 0, len(matrix) * n
        while lo < hi:
            mid = (lo + hi) // 2
            x = matrix[mid//n][mid%n]
            if x < target:
                lo = mid + 1
            elif x > target:
                hi = mid
            else:
                return True
        return False
