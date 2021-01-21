# Time Complexity: O(log rc)
class Solution:
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r = len(matrix)
        c = len(matrix[0])
        l = 0
        h = r*c - 1
        
        # perform Binary Search
        while l <= h:
            mid = l + (h-l) // 2
            # calculate the index of row and col
            row = mid // c
            col = mid % c
            
            # return True if the target is present
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                l = mid + 1
            else:
                h = mid - 1
        # else return False
        return False
        
        
        
        
        
        
        
            