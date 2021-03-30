# time complexity is O(log n)
# space complexity is O(1) since no auxiliary memory is created

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        columns = len(matrix[0])
        low = 0
        high = rows * columns -1
        
        if(len(matrix) == 0 or matrix == None):
            return False
                
        while (low <= high):
            mid = (low + high ) >> 1 #(low + high)//2 
            r = int(mid//columns)  # row index
            c = int(mid % columns) # column index
            
            # target found return true
            if (target == matrix[r][c]):
                return True
            
            # falls below mid value
            elif(target < matrix[r][c]):
                high = mid - 1
            
            # target falls above mid value
            else:
                low = mid + 1
        
        # when not found
        return False