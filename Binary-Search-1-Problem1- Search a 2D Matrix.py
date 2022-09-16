"""
 FAANMG Problem #5 {Medium}
Problem 1
74. Search a 2D Matrix

Time Complexity : O( n + log M )
 As for the Searching the wordt case would be the target is in last row (of size M)
 And logN binary search to find the value


Space Complexity : O(1)
Constant Space 

Did this code successfully run on Leetcode : Yes

As per the condition:
    • Integers in each row are sorted from left to right.
    • The first integer of each row is greater than the last integer of the previous row

So iterating row wise and comparing the last coulm element wit hthe target
    If the target is less than the last value of the row then A binary search on the corresponding 
    row to find the Target
    
    
@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    
    def binarySearch(self, arr, x, l, r):

        while (l <= r):
            mid = (l+r)//2

            if (arr[mid]==x):
                return True
        
            if (x < arr[mid]):
                r = mid -1
            
            else:
                l = mid+1    
            
        return False
    
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m = len(matrix)
        n = len(matrix[0])
        
        
        for idx, row in enumerate (matrix):
   
            if(target <= row[n-1]):
        
                if(self.binarySearch(row,target,0,n-1)):
                    return True
                else:
                    return False
         
    