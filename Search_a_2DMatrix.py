class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        
        low = 0
        high = rows-1
        
        while(low<=high):
            mid = low + ((high-low)//2)
            if(matrix[mid][-1]<target):
                low = mid+1
            elif(matrix[mid][0]>target):
                high = mid-1
            else:
                break
        if(not low<=high):
            return False
        row = low + ((high-low)//2)
        
        low = 0
        high = cols-1
        
        while(low<=high):
            mid = low + ((high-low)//2)
            if(matrix[row][mid]==target):
                return True
            elif(matrix[row][mid]<target):
                low = mid+1
            else:
                high = mid-1
        return False
               
            