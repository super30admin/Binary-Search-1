'''// Time Complexity : O(m + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach'''
class Solution(object):
    
    #Find the row in which the target might be present
    def targetRow(self,matrix, target, m, n):
        trow=0
        for row in range(0,m):
            if matrix[trow][n-1]<target:
                trow=row
        return trow
    
    #Binary Search implementation
    def BinarySearch(self, matrix, target, trow, l, h):
        
        while (h>=l):
            mid=l+(h-l)/2   
            if matrix[trow][mid] == target:
                return True
            elif target < matrix[trow][mid]:
                h=mid-1
            elif target > matrix[trow][mid]:
                l=mid+1
        return False
        
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        m=len(matrix)
        n=len(matrix[0])
        trow=self.targetRow(matrix,target, m, n)
        low=0
        high= n-1
        
        found=self.BinarySearch(matrix, target, trow, low, high)
        return found
            
        
        
