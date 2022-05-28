#Time complexity is O(logn)
#Space complexity is O(1)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or len(matrix)==0 : return False
        m=len(matrix)
        n=len(matrix[0])
        high=m*n-1
        low=0
        while low<=high:
            mid=low+(high-low)/2
            row=mid/n
            col=mid%n
            if matrix[row][col]==target : return True
            else:
                if matrix[row][col]>target:
                    high=mid-1
                else:
                    low=mid+1
        return False



