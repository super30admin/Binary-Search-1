'''
// Time Complexity : O(logn + log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
We check if the target is in a specific row by applying binary search
then once we have identified or narrowed down the row, we apply binary search
again.
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        RWS= len(matrix)
        CLS= len(matrix[0]) 
        
        top=0
        bottom=RWS-1
        while top<=bottom:
            m=(top+bottom)//2
            if target > matrix[m][-1]:
                top= m + 1
            elif target < matrix[m][0]:
                bottom=m-1
            else:
                break
        if not (top<=bottom):
            return False
        
        m=(top+bottom)//2
        start,end=0,CLS-1
        while start<=end:
            mid=(start+end)//2
            if target>matrix[m][mid]:
                start=mid+1
            elif target<matrix[m][mid]:
                end=mid-1
            elif target==matrix[m][mid]:
                return True
            else:
                return False
        