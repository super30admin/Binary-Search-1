"""
Problem : 6

Time Complexity : O(logn)
Space Complexity : O(mn)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Performing binary search on rows to find the matching row to search
then performing binary search on columns to find matching column where the target might be stored

"""

class Solution(object):
    def searchMatrix(self, matrix, target):
        # Deciding the row, using binary search on rows
        rows,cols=len(matrix),len(matrix[0])
        top=0
        bot=rows-1
        while top<=bot:
            row=(top+bot)//2
            if target>matrix[row][-1]:
                top=row+1
            elif target<matrix[row][0]:
                bot=row-1
            else:
                break
        # Deciding the column, using binary search on column
        if not(top<=bot):
            return False
        row=(top+bot)//2
        l,r=0,cols-1
        while l<=r:
            mid=(l+r)//2
            if target<matrix[row][mid]:
                r=mid-1
            elif target>matrix[row][mid]:
                l=mid+1
            else:
                return True
        return False