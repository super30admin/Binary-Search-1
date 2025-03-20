# Time Complexity : O(log n*m) where n is the number of rows and m is the number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Imagine the 2D matrix as a 1D array and apply binary search on it.
# Calculate the mid element and convert it to 2D index using the formula row = mid//COLS and col = mid%COLS.
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Get the number of rows and columns
        ROWS, COLS = len(matrix), len(matrix[0])
        # Initialize low and high pointers
        l, h = 0, (ROWS * COLS)-1
        while l <= h:
            # Calculate mid element
            mid = l + (h-l) // 2
            # Convert mid element to 2D index
            row, col = (mid//COLS), (mid%COLS)
            # If target is found, return True
            if matrix[row][col] == target:
                return True
            # If target is greater than mid element, search in the right half
            if matrix[row][col] < target:
                l = mid + 1
            # If target is smaller than mid element, search in the left half
            else:
                h = mid - 1
        # If target is not found, return False
        return False