# 74. Search a 2D Matrix

# Time Complexity: O(log(rows) + log(columns))

# The first binary search to find the correct row takes O(log(rows)) time
# The second binary search within the identified row takes O(log(columns)) time
# Combined, this gives O(log(rows) + log(columns)) which is efficient for large matrices

# Space Complexity: O(1)

# The algorithm uses a constant amount of extra space regardless of input size
# Only a few variables are used to track indices and bounds for the binary searches

# Did this code successfully run on Leetcode : YES

def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # Get the dimensions of the matrix
        rows = len(matrix)
        columns = len(matrix[0])
        
        # Initialize binary search bounds for finding the correct row
        target_rw_top = 0
        target_rw_bottom = rows - 1

        # First binary search to find the row that might contain the target
        while target_rw_top <= target_rw_bottom:
            # Calculate the middle row
            target_rw = (target_rw_top + target_rw_bottom) // 2 

            # If target is greater than the last element in the row, search in lower rows
            if target > matrix[target_rw][-1]:
                target_rw_top = target_rw + 1
            # If target is less than the first element in the row, search in upper rows
            elif target < matrix[target_rw][0]:
                target_rw_bottom = target_rw - 1
            # If target is within the range of this row, break and search this row
            else:
                break 
        
        # If the binary search ends without finding a suitable row, return False
        if not (target_rw_top <= target_rw_bottom):
            return False 

        # Recalculate the target row (this line is redundant if loop is broken)
        # handles edge case if the loop is not boken
        target_rw = (target_rw_top + target_rw_bottom) // 2 

        # Initialize binary search bounds for searching within the identified row
        l = 0
        r = columns - 1

        # Second binary search to find the target within the row
        while l <= r:
            # Calculate the middle column
            m = (l+r) // 2

            # If target is greater than the middle element, search in the right half
            if target > matrix[target_rw][m]:
                l = m + 1 
            # If target is less than the middle element, search in the left half
            elif target < matrix[target_rw][m]:
                r = m - 1
            # If target equals the middle element, return True (found)
            else:
                return True
        
        # If target wasn't found in the row, return False
        return False