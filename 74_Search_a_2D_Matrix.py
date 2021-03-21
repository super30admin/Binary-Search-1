class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        m, n = len(matrix), len(matrix[0])
        low, high = 0, m*n-1
        
        while (low <= high):
            
            mid = low + (high-low) // 2            
            i,j = mid//n, mid%n
            
            # Happy Case
            if matrix[i][j] == target:
                return True
                        
            if matrix[i][j] > target:
                high = mid-1            
            else:
                low = mid+1
            
        return False
    
### Complexity Analysis ###

# Time: O(logN) --> Search Space reduced to half in every iteration
# Space: O(1)