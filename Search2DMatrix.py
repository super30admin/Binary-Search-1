"""
Time Complexity : O(log(m*n)) = O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        m = len(matrix) 
        n = len(matrix[0])
        left, right = 0, m*n-1
        # Do binary search on the matrix
        # matrix[]
        while left <= right:
            mid = (left + right)//2
            pivot = matrix[mid//n][mid%n]
            if target == pivot:
                return True
            else:
                if target < pivot:
                    right = mid - 1
                else:
                    left = mid + 1
        return False