class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top, bottom = 0, len(matrix)-1
        while top<=bottom:
            midRow = (top+bottom)//2
            if matrix[midRow][-1] < target:
                top = midRow + 1
            elif matrix[midRow][0] > target:
                bottom = midRow -1
            else:
                break
        
        if not (top <= bottom):
            return False 
        
        row = (top+bottom)//2
        l = 0
        r = len(matrix[0]) - 1
        while l <= r:
            mid = (l+r)//2
            if matrix[row][mid] < target:
                l = mid +1
            elif matrix[row][mid] > target:
                r = mid -1
            else:
                return True 
        return False  