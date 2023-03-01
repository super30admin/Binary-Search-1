# Time Complexity : O(log(m*n))
# Space Complexity : O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        
        row = len(matrix)
        col = len(matrix[0])

        i, j = 0, row * col - 1
        while i <= j:
            mid = (i + j)//2
            elem = matrix[mid // col][mid % col]
            if target == elem:
                return True
            elif target > elem:
                i = mid + 1
            else:
                j = mid - 1
        return False
