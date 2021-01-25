class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) ==0:
            return False
        l,r=0,len(matrix)-1
        while l<=r:
            mid = (l+r)//2
            if target>=matrix[mid][0] and target<=matrix[mid][-1]:
                return self.binarysearch(matrix,mid,target)
            if target < matrix[mid][0]:
                r=mid-1
            elif target>matrix[mid][-1]:
                l=mid+1
        return False
    def binarysearch(self, matrix, row, target):
        l,r = 0, len(matrix[row])
        while l<=r:
            mid = (l+r)//2
            if target == matrix[row][mid]:
                return True
            if target > matrix[row][mid]:
                l =mid+1
            elif target < matrix[row][mid]:
                r =mid-1
        return False