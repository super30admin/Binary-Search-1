# Time Complexity : O(log(mn))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
from typing import List
class Solution:
    def searchMatrix(self, matrix:List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n -1

        if(matrix is None or len(matrix)==0):
            return False

        while(low<=high):
            mid = low + (high-low)//2
            r = mid // n
            c = mid % n

            if(matrix[r][c]==target):
                return True
            elif(matrix[r][c] > target):
                high = mid - 1
            else:
                low = mid + 1
            
        return False

sc = Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
print(sc.searchMatrix(matrix, target))