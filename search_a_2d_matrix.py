
# Time complexity : O(m*n)
#  Space complexty : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        
        l = 0
        r = len(matrix) * len(matrix[0]) - 1
        
        while l <= r:
            mid = (l + r) //2
            X = mid // len(matrix[0])
            Y = mid % len(matrix[0])
            num = matrix[X][Y]
               
            if num == target:
                return True
            elif target > num:
                l = mid + 1
            
            else:
                r = mid - 1
        return False

