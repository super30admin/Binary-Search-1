#Time Complexity:O(log n*m)
#Space Complexity:O(1)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        l=0
        h=len(matrix)*len(matrix[0])-1
        while(l<=h):
            mid=(l+h)//2
            row=mid//len(matrix[0])
            column=mid%len(matrix[0])
            if(target>matrix[row][column]):
                l=mid+1
            elif(target<matrix[row][column]):
                h=mid-1
            else:
                return True
        return False