class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    
        if not matrix:
            return False
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        low, high = 0, (rows*cols)-1
        while low<=high:
            
            mid = low + (high-low)//2

            r = mid // cols
            c = mid % cols
            
            if matrix[r][c] == target:
                return True
            elif target<matrix[r][c]:
                high = mid - 1
            
            else:
                low = mid + 1
        
        return False
            
# Time and Space Complexity - Time Complexity log n as we are applying binary search

# Approach is to imagine a linear array and find the mid element. Now as the values are sorted as they would be in a linear array, we just find the row and col of the middle element using / and % operations with number of columns.
# Now we can check if target is > or < the middle value, once we have row and column indexes.
#Now apply odinary binary search and get the answer.
            
        
        
        
        
