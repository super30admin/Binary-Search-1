class Solution(object):
    def searchMatrix(self, matrix, target):  
        
        row = len(matrix)
        col = len(matrix[0])
        
        low = 0
        high = (row*col)-1
        
        while low <= high: 
            mid = (low + high) // 2
            r = mid / col
            c = mid % col
            if target == matrix[r][c]:
                return True
            if target < matrix[r][c]:
                high = mid - 1
            else:
                low = mid + 1
        return False
    
        
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        