# Time Complexity : O(log(rows*cols))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We will virtually flatten the matrix and treat it as a list in the instances where we need and perform binary search on it.

from typing import List
class Solution: 
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:   
        if not matrix:
            return -1
        rows=len(matrix)
        cols=len(matrix[0])
        low,high=0,(rows*cols)-1
        
        while low<=high:
            mid=(low+high)//2
            midval=matrix[mid//cols][mid%cols]
            if midval==target:
                return True
            elif target<midval:
                high=mid-1
            else:
                low=mid+1
        return False

    # def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    #     for i in range(len(matrix)):
    #         if matrix[i][0]<=target<=matrix[i][-1]:
    #             for j in range (len(matrix[i])):
    #                 if matrix[i][j]==target:
    #                     return True
    #     return False

obj=Solution()
print(obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],34))