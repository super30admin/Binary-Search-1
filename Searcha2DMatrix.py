# ----------------------------
# Time Complexity - O(log m*n) m is the number of rows and n is number of columns
# Space Complexity - O(1)
# ----------------------------

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         base case
        if matrix is None or target is None:
            return False
        
        m=len(matrix)
        n=len(matrix[0])
        
        l=0
        h=(m*n)-1
        
        while(l<=h):
            mid=(l+h)//2
            # Find the row
            row=mid//n
            # find the columns
            col=mid%n
            if matrix[row][col]==target:
                return True
            elif (target<matrix[row][col]):
                h=mid-1
            else:
                l=mid+1
            
        return False
            