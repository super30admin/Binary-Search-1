'''// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach'''
class Solution(object):
    
    #Find Target by applying Binary search on col 1           
    def targetRow(self,matrix, target, m, n):
        l=0
        h=m-1
        while(h>=l):
            mid=l+(h-l)/2
            if matrix[mid][0]<=target and matrix[mid][n-1] >=target :
                return mid
            elif matrix[mid][0]>target:
                h=mid-1
            else:
                l=mid+1
    
    #Binary Search on the target row
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
        
        if trow==None:
            return False
        
        found=self.BinarySearch(matrix, target, trow, low, high)
        return found
            
        
        
