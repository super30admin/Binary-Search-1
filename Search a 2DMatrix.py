""""// Time Complexity : O(log(m)+log(n)) = O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""



class Solution:
    def searchMatrix(self, matrix, target):
        l=0
        r=len(matrix)-1
        while l<=r:
            mid=l+(r-l)//2
            if target<matrix[mid][0]:
                r=mid-1
            elif target>matrix[mid][-1]:
                l=mid+1
            else:
                break
        l=0
        r=len(matrix[mid])-1
        while l<=r:
            x=l+(r-l)//2
            if matrix[mid][x]==target:
                return True
            elif target>matrix[mid][x]:
                l= x+1
            else:
                r= x-1
        return False
obj=Solution()
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3))