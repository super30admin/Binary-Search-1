"""
Space Complexity: O(1) We are not using any extra memory objects, so the space complexity is constant
Time Complexity: O(log(mn)) We are iterating through the array as if its a linear list, and doing binary search.
"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        R,C = len(matrix), len(matrix[0])

        left, right = 0, R*C-1

        while left <= right: 
            mid = left + (right-left) // 2
            r,c = mid//C, mid%C
            if matrix[r][c] == target: 
                return True
            elif target < matrix[r][c]: 
                right = mid-1
            else: 
                left = mid+1
        return False
