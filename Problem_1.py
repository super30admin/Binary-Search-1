# Time Complexity : O(log(mn)) where matrix size is m*n
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        # Interpret the 2D matrix as a 1D matrix
        # Initial search bounds
        lo = 0
        hi = rows*cols - 1
        while lo <= hi:
            # Calculate mid index for the present search bounds
            mid = (lo + hi) // 2
            # Convert mid index of the 1D matrix to the row and col of 2D matrix
            row = mid // cols
            col = mid % cols
            # If target found at row and col corresponding to mid index of equivalent 1D array, return True
            if matrix[row][col] == target:
                return True
            # If element at row and col corresponding to mid index of equivalent 1D array is greater than target, search in the left part of equivalent 1D array
            elif matrix[row][col] > target:
                hi = mid - 1
            # If element at row and col corresponding to mid index of equivalent 1D array is smaller than target, search in the right part of equivalent 1D array
            else:
                lo = mid + 1
        # If target is not found, return False
        return False