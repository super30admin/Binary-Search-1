class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        colLen = len(matrix[0])
        rowLen = len(matrix)
        high = rowLen * colLen - 1
        low = 0

        while low <= high:
            mid = low + (high - low)//2
            row = mid // colLen
            col = mid % colLen
            if matrix[row][col] == target:
                return True
            if target > matrix[row][col]:
                low = mid + 1
            elif target < matrix[row][col]:
                high = mid - 1
        return False
