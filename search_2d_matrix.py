class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        d = len(matrix[0])
        low = 0
        high = (len(matrix)*len(matrix[0]))-1
        #print(low, high)
        
        while low <= high:
            mid = (low + high)//2
            r = mid // d
            c = mid % d
            #print('low:', low, 'high:', high, 'mid:', mid, 'r:', r, 'c:', c, 'mat value: ' , matrix[r][c])
            
            if matrix[r][c] == target:
                return True
            elif target < matrix[r][c]:
                high = mid - 1
            elif matrix[r][c] < target:
                low = mid + 1
        
        return False
                
        
