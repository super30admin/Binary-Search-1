# Time Complexity: O(log(nm))
# Space Complexity: O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        l = 0
        r = (rows * cols) - 1
        while l <= r:
            mid = l + (r - l) // 2
            mid_r = mid // cols 
            mid_c = mid % cols
            val = matrix[mid_r][mid_c] 

            if val == target:
                return True
            elif val < target:
                l = mid + 1
            else:
                r = mid - 1
            
        return False
            
