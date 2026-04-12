class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        cols = len(matrix[0])
        rows = len(matrix)

        top = 0
        bot = rows - 1
        found = False
        while top <= bot:
            row = top + (bot - top)//2
            if matrix[row][0] > target:
                bot = row - 1
            elif matrix[row][-1] < target:
                top = row + 1
            else:
                found = True
                break
        
        if not found:
            return False
        left = 0
        right = len(matrix[0])-1
        while left <= right:
            mid = left + (right - left)//2
            if matrix[row][mid] == target:
                return True
            if matrix[row][mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return False