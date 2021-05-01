import math
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        high = len(matrix) * len(matrix[0])-1
        while(low<=high):
            mid = math.floor(low+(high-low)/2)
            row = math.floor(mid / len(matrix[0]))
            column = math.floor(mid % len(matrix[0]))
            if matrix[row][column]==target:
                return True
            elif matrix[row][column] > target:
                high = mid - 1
            else:
                low = mid + 1
        
