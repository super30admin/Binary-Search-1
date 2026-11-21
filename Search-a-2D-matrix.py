class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        rows=len(matrix)
        cols=len(matrix[0])
        # print(m,n)
        low=0
        high=(rows*cols)-1
        while low<=high:
            mid=(low+high)//2
            r=mid//cols
            c=mid%cols
            if matrix[r][c]==target:
                return True
            elif matrix[r][c]>target:
                high=mid-1
            else:
                low=mid+1
        return False
        