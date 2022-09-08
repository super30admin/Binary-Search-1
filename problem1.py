#search in a 2-d Matrix
#SC:O(N)
#TC:O(logN)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix)==0: #edge case to check if matrix is empty
            return False
        rows = len(matrix) #initalzing row
        col = len(matrix[0])#initializing columns
        low =0 #left pointer
        high = (rows*col)-1#right pointer
        while(low<=high): #performing basic binary search
            mid = low +(high-low)/2
            mid_element = matrix[mid/col][mid%col]
            if (mid_element==target):
                return True
            elif (target>mid_element):
                low = mid+1
            else:
                high = mid-1
        return False