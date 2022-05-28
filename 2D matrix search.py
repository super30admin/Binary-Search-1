# time complexity log(n)
# space complexity o(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix) 
        cols = len(matrix[0])
        high = rows*cols - 1
        low = 0
        while(low <= high):
            mid = low + (high - low)//2
            c = mid % cols
            r = mid // cols
            if(matrix[r][c] == target):
                return True
            elif(matrix[r][c] < target):
                low = mid + 1
            else:
                high = mid - 1
        return False
        
        
        
        
        
        
        