# I went with the approach of treating the matrix as a list and applied binary search
# Checked rows and cols number to find out which gives the middle element of the matrix for multiple use cases
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows=len(matrix)
        cols=len(matrix[0])
        left=0
        right=(rows*cols)-1
        while left<=right:
            mid = (left+right)//2
            r=mid//cols
            c=mid%cols
            if matrix[r][c]==target:
                return True
            elif matrix[r][c]>target:
                right=mid-1
            else:
                left=mid+1
        return False

        