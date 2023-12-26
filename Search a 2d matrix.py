class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return false
        rows = len(matrix)
        column = len(matrix[0])
        low = 0
        high = rows * column - 1

        while low <= high:
            mid = (low + high) // 2
            mid_value = matrix[mid // column][mid % column]

            if mid_value == target:
                return True
            elif mid_value < target:
                low = mid + 1
            else:
                high = mid - 1
        return False
