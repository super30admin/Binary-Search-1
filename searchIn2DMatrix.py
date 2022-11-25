#Time Complexity :  log(m) + log(n) or log(mn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0: return False
        m = len(matrix)                                         #calculating rows                
        n = len(matrix[0])                                      #calcuating cols
        
        low = 0                                                 #low is initially at 0
        high = m*n-1                                            #high is at last index
        
        while low <= high:                                      #run Binary search
            mid = low + (high-low)//2                           #find mid in the imaginary 1D array
            r = mid//n                                          #using mid find the correct row containing mid in 2D matrix
            c = mid%n                                           #using mid find the correct col containing mid in 2D matrix                        
            if matrix[r][c] == target:                          #if elem at mid in 2D matrix is the target we return true
                return True
            elif matrix[r][c] > target:                         #if elem at mid is greater than target we change high to mid - 1
                high = mid - 1
            else:                                               #otherwise we change low to mid + 1
                low = mid + 1
        return False