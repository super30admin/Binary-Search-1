class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        high = m * n - 1
        low = 0

        while (low <= high):
            mid = low + (high - low) // 2
            column_index = mid % n
            row_index = mid // n
            mid_value = matrix[row_index][column_index]
            if (mid_value == target):
                return True
            elif mid_value < target:
                low = mid + 1
            else:
                high = mid - 1
        return False