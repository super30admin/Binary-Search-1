 # Time Complexity : O(log(m*n)) as we are using binary search => O(log(m)*log(n))
 # Space Complexity : O(1)
 # Did this code successfully run on Leetcode : Yes
 # Any problem you faced while coding this : None
class Solution:
    # Function to search the element in 2D Matrix
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix) # gives the length of row
        col = len(matrix[0]) # gives the lenth of cols
        low = 0
        high = row*col - 1 # Gives the last index of the matrix
        if row == 0: # empty matrix
            return False
        # Doing binary search
        while low <= high:
            pivot_index = low + ((high-low) // 2) # To avoid integer overflow if integer values are too high
            row_index = pivot_index // col
            col_index = pivot_index % col
            pivot_element = matrix[row_index][col_index]
            if target == pivot_element: # element found
                return True
            else:
                if target < pivot_element: #element is on left side
                    high = pivot_index - 1
                else: # element is on right side
                    low = pivot_index + 1
        return False # element not found
