# // Time Complexity : O(log m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        # binary search
        left, right = 0, m*n - 1
        while left <= right:
            mid = (left + right) // 2 # to get mid index
            pivot_element = matrix[mid//n][mid%n] # to get mid element
            if pivot_element == target:
                return True
            elif pivot_element > target:
                right = mid - 1
            else:
                left = mid + 1