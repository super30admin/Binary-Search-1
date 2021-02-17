# O(LOG(M*N)) TIME AND O(1) SPACE WHERE M IS ROWS AND N IS COLS
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0
        high = rows * cols - 1
        while low <= high:
            mid = (low + high)//2
            num = matrix[mid // cols][mid % cols]
            if num == target:
                return True
            elif target < num:
                high = mid - 1
            else:
                low = mid + 1
        return False