#Time Complexity : O(logn)
#Space Complexity : O(mn)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution(object):
     def searchMatrix(self, matrix, target):
        m=len(matrix)
        n=len(matrix[0])
        l,h=0,m*n-1

        while l<=h:
             mid=l-(l-h)/2
            r=mid/n
             c=mid%n
             if matrix[r][c]==target:
                 return True
             elif matrix[r][c]>target:
                 h=mid-1
             else:
                 l=mid+1
         return False
