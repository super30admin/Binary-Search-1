class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for x in matrix:
            if target in x:
                return True
        return False
