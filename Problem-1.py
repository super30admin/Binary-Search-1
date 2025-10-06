# Time Complexity : O(log(m * n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Approach: Treat the 2D matrix as a 1D sorted array to apply binary search
        m = len(matrix)
        n = len(matrix[0])
        low = 0  # Initialize the low pointer
        high = m * n - 1  # High pointer is the last element index (total elements - 1)
        
        while low <= high:
            mid = low + (high - low) // 2  # Calculate mid index
            row = mid // n  # Convert 1D mid index to row index
            column = mid % n  # Convert 1D mid index to column index
            
            # Check if the mid element matches the target
            if matrix[row][column] == target:
                return True
            # If mid element is smaller than target, search the right half
            elif matrix[row][column] < target:
                low = mid + 1
            # If mid element is greater than target, search the left half
            else:
                high = mid - 1
        
        # Target not found
        return False
