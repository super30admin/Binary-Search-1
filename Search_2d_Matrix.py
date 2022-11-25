class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix==None or len(matrix)==0:
            return False
        m=len(matrix)
        n=len(matrix[0])
        l=0
        h=(m*n)-1
        while l<=h:
            mid=l+(h-l)//2
            row=mid//n
            col=mid%n
            if matrix[row][col]==target:
                return True
            elif target>matrix[row][col]:
                l=mid+1
            else:
                h=mid-1
        return False
            
