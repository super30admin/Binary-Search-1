

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        n_cols = len(matrix[0])
        n_rows = len(matrix)
        high = (n_rows * n_cols) - 1

        while low <= high:
            mid = (high + low) // 2
            row = mid // n_cols
            col = mid % n_cols
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1

        