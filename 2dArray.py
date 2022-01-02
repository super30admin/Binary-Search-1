class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        for a in matrix:
            
            m = len(matrix)
            n = len(matrix[0])
            
            low = 0
            high = m*n -1
            
            while low <=high :
                
                mid = low +(high-low)//2
                
                midRow = mid//n
                midCol = mid%n
                if(matrix[midRow][midCol]== target):
                    return True
                elif target > matrix[midRow][midCol]:
                    low = mid+1
                else:
                    high = mid - 1
            
            return False