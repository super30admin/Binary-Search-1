class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if len(matrix) == 0:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        
        low = 0
        high = m*n-1
        
        while(low <= high):
            mid = int(low + (high-low)/2)
            midvalue = matrix[int(mid/n)][int(mid%n)]
            
            if midvalue == target:
                return True
            elif midvalue > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return False