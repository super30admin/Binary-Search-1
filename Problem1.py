class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix:
            m = len(matrix)
            n = len(matrix[0])
            low = 0
            high = m*n -1
            while low <= high:
                mid = low + (high - low)//2
                row = mid//n
                col = mid%n
                
                if matrix[row][col] == target:
                    return True
                elif matrix[row][col] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return False
        else:
            return False
                
# Time compelxity is log(m*n) since we are imagining a flattened list of length m*n and performing a binary search over it.        
            
                    
                
        