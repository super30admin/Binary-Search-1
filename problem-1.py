# Time complexity is O(log(m)+n) space complexity is O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#Initializing row and column length        
        r=len(matrix)
        c=len(matrix[0])
# Traversing rows to check if target is present        
        for i in range(0,r):
            if target <= matrix[i][c-1]:
                s=0
                e=c-1
                
                while s<=e:
                    m = s+(e-s)//2
# Return true if row element matches target                   
                    if matrix[i][m]==target:
                        return True
                    
                    if matrix[i][m]<target:
                        s=m+1
                    else:
                        e=m-1
                        
        return False