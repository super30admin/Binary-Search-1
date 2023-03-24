class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix==None and len(matrix)==0:
            return False
        
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1
            
        while low<=high:
            mid=low+(high-low)//2
            row=mid//n
            col=mid%n
            if matrix[row][col]==target:
                return True
            elif target<matrix[row][col]:
                high=mid-1
            else:
                low=mid+1
        return False