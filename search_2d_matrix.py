"""
Approach:
-> Treat the 2D matrix as a 1D array and perform binary search on it.
-> Map the 1D array index to 2D array index using the formula:
matrix_row_index = mid//col_length
matrix_col_index = mid%col_length
-> Perform Binary search and update low and high pointers accordingly.

Time Complexity:
O(logmn) or O(logm) + O(logn) - binary search

Space Complexity:
O(1) - constant space

"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_length = len(matrix)
        col_length = len(matrix[0])
        low, high = 0, row_length*col_length-1

        while low <= high:
            mid = low + (high-low)//2

            # map 1d list index to 2d list index
            matrix_row_index = mid//col_length
            matrix_col_index = mid%col_length

            if matrix[matrix_row_index][matrix_col_index] == target:
                return True
            
            elif matrix[matrix_row_index][matrix_col_index] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False