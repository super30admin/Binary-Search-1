# Complexity: O(log n*m)

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        n = len(matrix)
        m = matrix[0].length
        
        low = 0
        high = n * m - 1
        
        while low <= high:
            mid = (low + high) // 2
            i = mid / m
            j = mid % m
            
            if (matrix[i][j] == target):
                return True
            elif matrix[i][j] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False