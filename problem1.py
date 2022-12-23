class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i=0
        j=len(matrix[0])-1
        while i>=0 and i<len(matrix) and j>=0 and j<len(matrix[0]):
            if target==matrix[i][j]:
                return True
            else:
                if target<matrix[i][j]:
                    j-=1
                else:
                    i+=1
        return False
                    