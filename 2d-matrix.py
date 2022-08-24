class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m= len(matrix)
        if not m:
            return False
        
        n= len(matrix[0])
        low =0 
        high = m*n-1
        
        while low <=high:
            
            mid = low + (high-low)//2
            curr = matrix[mid//n][mid%n]
            
            if target == curr:
                return True
            elif target < curr:
                high = mid-1
            else:
                low= mid+1
                
        return False
