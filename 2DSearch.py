#TimeComplexity:O(logmn)
#SpaceComplexity:O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row,col=len(matrix),len(matrix[0])
        low,high=0,row*col-1
        while low<=high:
            mid= low + (high-low)//2
            num=matrix[mid//col][mid%col]
            if num==target:
                return True
            if num>target:
                high=mid-1
            else:
                low=mid+1
        return False