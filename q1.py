from typing import List
#Did this code successfully run on Leetcode :O(log(m)+log(n))
#Any problem you faced while coding this : Not any problem anything specific
#Here all the methods have the space complexity of O(1)
class Solution:
    '''Time Complexity of the following method is O(log(m)) as it is just a binary search on a column'''
    def findrow(self,matrix,target,l,r)->int:
        #This method is used to find the row
        while(l<=r):
            mid=(l+r)//2
            if(target in range(matrix[mid][0],matrix[mid][-1]+1)):
                return mid
            if(target < matrix[mid][0]):
                #left side
                l,r=l,mid-1
            if(target > matrix[mid][-1]):
                #right side
                l,r=mid+1,r
        return -1
    
    '''Time Complexity of the following method is O(log(n)) as it is just a binary search on a row'''
    def findcol(self,matrix,target,l,r,row)->bool:
        #This method is used for find the col, in the given row 
        while(l<=r):
            mid=(l+r)//2
            if(matrix[row][mid]==target):
                return True
            if(matrix[row][mid] < target):
                #right side
                l,r=mid+1,r
            if(matrix[row][mid] > target):
                #left side
                l,r=l,mid-1
        return False

    '''Time complexity of the this method is O(log(m)+log(n)) as it uses two methods defined above'''
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows=len(matrix)
        if(rows!=0):
            cols=len(matrix[0])
        #print(rows,cols)
        r=self.findrow(matrix,target,0,rows-1)
        #print(r)
        if(r==-1):
            return False
        else:
            return self.findcol(matrix,target,0,cols-1,r)
            
        
            
        