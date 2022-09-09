# Time complexity: O(logn)
# Space complexity: O(1)

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        if len(matrix) == 0:
            return False
        
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0
        high = (rows * cols) - 1
        
        while low <= high:
            mid = low + (high - low) // 2        # Prevent integer overflow
            mid_element = matrix[mid // cols][mid % cols]
            
            if mid_element == target:
                return True
            
            elif target > mid_element:
                low = mid + 1
                
            else:
                high = mid - 1
                
        return False
