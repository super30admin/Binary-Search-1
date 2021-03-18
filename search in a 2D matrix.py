class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        if not matrix or not matrix[0]:
            return false

        n_rows = len(matrix)
        n_cols = len(matrix[0])

        row, col = 0, n_cols - 1

        while True:
            if row < n_rows and col >= 0:
                if matrix[row][col] == target:
                    return True
                elif matrix[row][col] < target:
                    row += 1
                else:
                    col -= 1
            else:
                return False
