# LC 74 - Search a 2D matrix
# Time Complexity : O(log N)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            print('False')
        n = len(matrix[0])
        low, mid, high = 0, 0, (n*len(matrix)) - 1
        while bot <= high:
            mid = (low + high) // 2
            if target == matrix[mid//n][mid%n]:
                return True
            elif target > matrix[mid//n][mid%n]:
                bot = mid + 1
            else:
                high = mid - 1
        return False
