class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix==None or len(matrix)==0:
            return False
        m=len(matrix)
        n=len(matrix[0])
        low,high=0,m*n-1
        while low<=high:
            mid=low+(high-low)//2
            print(mid,high,low,target)
            r=int(mid/n)
            c=int(mid%n)
            if target==matrix[r][c]:
                return True
            elif target < matrix[r][c]:
                high=mid-1
            else:
                low=mid+1
        return False
