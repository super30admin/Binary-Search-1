#time complexity: o(logn)
#space complexity: O(1)
#passed all cases on LeetCode: yes
#difficulty faced: deciding mid and then assigning row and column
# comments: we do the div operation for getting the row bec each row has equal num of cols while the mod operation is needed to set the range
#https://leetcode.com/problems/search-a-2d-matrix/

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0:
            return False
    
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        lo = 0
        hi = rows*cols-1
        
        while lo <= hi:
            
            mid = lo + (hi-lo)//2
            #this is done this way and not just high+low/2 so that index doesnt go out of bounds
    
            r = mid//cols
            c = mid%cols
            
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                lo = mid + 1                
            else:
                hi = mid - 1
        return False
        
        