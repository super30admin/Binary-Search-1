"""
# Time Complexity : O(log(n))
# Space Complexity : O(1) as we are storing only low, mid and high.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""
class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or matrix == None:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n-1
        while low <= high:
            mid = low+(high-low)//2
            r = mid//n
            c = mid%n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid-1
            else:
                low = mid+1
        return False