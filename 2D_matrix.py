class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not (matrix[0]):
            return False
        m=len(matrix)
        n=len(matrix[0])
        l=0
        h=(m*n)-1
        while(l<=h):
            mid=(l+h)//2
            r=mid//n
            c=mid%n
            if(matrix[r][c]==target):
                return True
            elif (target>matrix[r][c]):
                l=mid+1
            else:
                h=mid-1
        return False
                