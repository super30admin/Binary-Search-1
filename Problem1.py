class Solution:
    def searchMatrix(self,matrix,target):
        if not matrix or not matrix[0]:
            return False
        
        m,n=len(matrix),len(matrix[0])
        left,right=0,m*n-1

        while left<=right:
            mid=(left+right)//2
            row=mid//n
            col=mid%n
            mid_value=matrix[row][col]

            if mid_value==target:
                return True
            elif mid_value<target:
                left=mid+1
            else:
                right=mid-1
        return False
    
sol=Solution()
print(sol.searchMatrix(matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3))
print(sol.searchMatrix(matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13))