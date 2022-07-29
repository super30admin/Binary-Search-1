class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:#time O(logn) space O(1)
        if len(matrix)==0 or matrix==None:return False
        l=0;h=len(matrix)*len(matrix[0])-1
        while l<=h:
            mid=(l+h)//2
            r=mid//len(matrix[0])
            c=mid%len(matrix[0])
            if matrix[r][c]==target:return True
            elif matrix[r][c]<target:l=mid+1
            else : h=mid-1
        return False
