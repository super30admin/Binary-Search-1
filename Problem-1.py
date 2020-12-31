class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # Time Complexity :O(logn)
        #Space Complexity :O(1)
        #Did this code successfully run on Leetcode :Yes
        #Any problem you faced while coding this : Getting row and column
        
        
        if(matrix==None or len(matrix)==0):
            return False
        
        m=len(matrix)
        n= len(matrix[0])
        
        low= 0
        high = m*n -1
        
        while(low<=high):
            mid=low+(high-low)//2
            r=mid/n
            c=mid%n
            if(matrix[r][c]==target):
                return True
            elif(matrix[r][c]<target):
                low=mid+1
            else:
                high=mid-1
        return False
                
        
        