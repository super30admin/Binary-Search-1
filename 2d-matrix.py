# Time Complexity is O(log m + log n)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLUMNS = len(matrix), len(matrix[0])

        top_row, bottom_row = 0, ROWS - 1                            # Initialize the row pointers in the matrix.
        while top_row <= bottom_row:
            middle_row = (top_row + bottom_row) // 2
            if target > matrix[middle_row][-1]:                     # Checking to see if the target value is greater than the largest value in the determined middle row.
                top_row = middle_row + 1                            # Shift top_row to middle row + 1 to reduce the search space downwards in the matrix.
            elif target < matrix[middle_row][0]:                    # Checking to see if the target value is less than the smallest value in the determined middle row.
                bottom_row = middle_row - 1                         # Shift bottom_row to middle row - 1 to reduce the search space upwards in the matrix.
            else:
                break
        
        if not(top_row <= bottom_row):                              # None of the rows has target value.
            return False

        middle_row = (top_row + bottom_row) // 2                    # Row on which the 2nd binary search is to be run to find the target.
        left, right = 0, COLUMNS - 1                                # Initialize left and right pointers in that column.
        while left <= right:
            middle = (left + right) // 2
            if target > matrix[middle_row][middle]:
                left = middle + 1                                   # Shifting to right side.
            elif target < matrix[middle_row][middle]:
                right = middle - 1                                  # Shifting to left side.
            else:
                return True
        return False