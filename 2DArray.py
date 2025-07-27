#Time Complexity : O(logm+logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m=len(matrix)   #num of rows
        n=len(matrix[0]) #num of cols

        low=0           #first element
        high=m*n-1      #last element
        while(low<=high):
            mid=low+(high-low)/2
            r=mid/n      # row of the mid element in the matrix
            c=mid%n      # col of the mid element in the matrix
            if matrix[r][c]==target:  #check if it is the target
                return True           
            elif matrix[r][c]>target:  # if it is greater than the target shift high
                high=mid-1
            else:                      # if it is lesser than the target shift high
                low=mid+1
        return False

        