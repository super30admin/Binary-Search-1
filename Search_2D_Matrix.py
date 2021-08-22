# time complexity: O(logn) + O(logm)
#space complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        left_col = 0
        right_col = len(matrix) - 1
        left_row = 0
        right_row = len(matrix[0]) - 1
        col_idx = -1
        while left_col <= right_col:
            mid_col = (left_col + right_col)//2
            if matrix[mid_col][0] <= target <= matrix[mid_col][right_row]:
                col_idx = mid_col
                break
            if matrix[mid_col][0] < target:
                left_col = mid_col + 1
            elif matrix[mid_col][0] > target:
                right_col = mid_col - 1
                
        
        while left_row <= right_row:
            mid_row = (left_row + right_row)//2
            if matrix[col_idx][mid_row] == target:
                return True
            elif matrix[col_idx][mid_row] > target:
                right_row = mid_row - 1
            elif matrix[col_idx][mid_row] < target:
                left_row = mid_row + 1
        
        return False
                
            
        
        