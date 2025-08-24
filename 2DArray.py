#Time Complexity : (O(log(m⋅n))
#Space Complexity: O(1)

"""
here is a version that flattens the 2D matrix into a virtual 1D array and binary searches it.
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m * n - 1
        
        while low <= high:
            mid = (low + high) // 2
            val = matrix[mid // n][mid % n]
            
            if val == target:
                return True
            elif val < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return False