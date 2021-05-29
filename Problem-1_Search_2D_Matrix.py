class Solution:
    def searchMatrix(self, matrix, target):
        
        if not matrix:
            # Reject invalid input, empty 1D list
            return False
        
        # Get height and width from input matrix
        m, n = len(matrix), len(matrix[0])
        
        if m * n == 0:
            # Reject invalid input, empty 2D list
            return False
        
        # Binary seach on head elements of each row
        lower, upper = 0, m-1
        while lower <= upper:
            
            mid = lower + (upper-lower)//2
            
            mid_row_head_value = matrix[mid][0]
            
            if mid_row_head_value > target:
                upper = mid-1
            elif mid_row_head_value < target:
                lower = mid+1
            else:
                return True

        # Binary seach on the possible row
        row_idx = upper
        lower, upper = 0, n-1
        
        while lower <= upper:
            
            mid = lower + (upper-lower)//2
            
            mid_value = matrix[row_idx][mid]
            
            if mid_value > target:
                upper = mid-1
            elif mid_value < target:
                lower = mid+1
            else:
                return True
            
        return False

#Implementing Search for 2D matrix problem using Binary search with time complexity O(logm + logn)
