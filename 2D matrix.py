#Time Complexity : O(lognm)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :Yes, code runs in python but not in python 3

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        n = len(matrix) # number of rows
        m = len(matrix[0]) # number of columns 
        
        low = 0
        high = (m*n) -1
        
        while (low<=high):
            mid = low +(high-low)/2
            i = mid/m
            j = mid%m
            
            if (matrix[i][j] == target):
                return True
            elif (matrix[i][j]< target):
                low = mid+1
            else:
                high = mid-1
        return False
        
        
