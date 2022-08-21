class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n=len(matrix)
        m=len(matrix[0])
        low=0
        high=m*n -1
        while (low<=high):
            mid=(low+high)//2
            row=mid//m
            col=mid%m
            if(matrix[row][col]==target):
                return True
            elif matrix[row][col]>target:
                high=mid-1
            else:
                low=mid+1
            
        return False 