## Problem1 
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : both the codes has almost same run time. 

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low =  0 
        m = len(matrix)
        n = len(matrix[0])
        high = m * n - 1
        while low<=high:
            mid = low + int((high - low)/2)
            row = mid // n
            col = mid % n
            if target == matrix[row][col]: 
                return True
            elif target > matrix[row][col]:
                low = mid + 1
            else:
                high = mid - 1
        return False
        # Binary search untill find the row - old code 
        # fr = 0
        # lr = len(matrix) - 1
        # while fr<=lr:
        #     mr = int(fr + (lr - fr)/2)
        #     if matrix[mr][0]<=target and target<=matrix[mr][-1]:
        #         if target in matrix[mr]:
        #             return True
        #         else:
        #             return False
        #     elif target<matrix[mr][0]:
        #         lr = mr - 1
        #     elif target>matrix[mr][-1]:
        #         fr = mr + 1
