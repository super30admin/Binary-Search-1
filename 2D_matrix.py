# // Time Complexity : # we will have O(mn) complexity
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Initially 
class Solution:
    def searchMatrix(self, matrix, target: int) -> bool:
        m=len(matrix) 
        n=len(matrix[0])
        s=0 
        e=m*n-1
    #    we will use virtual flatten: we do not do it for all matrix, but only for elements we need: if we need element number e from our flattened list, it coresponds to element matrix[mid//n][mid%n] in our matrix. 
        while s <=e:
            
            mid= s+(e-s)//2
            
            i=mid//n
            j=mid%n
            
            if(matrix[i][j]==target):
                return True
            elif matrix[i][j]< target:
                s=mid+1
            else:
                e=mid-1
        return False

s=Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
print(s.searchMatrix(matrix,target))
