# Time Complexity : O(log(m*n))
# Space Complexity :O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        
        if target<matrix[0][0] or target>matrix[m-1][n-1]:
            return False
        i = 0
        j = n-1
        
        while j>=0 and i<=m-1:
            if matrix[i][j]>target:
                j-=1
            elif matrix[i][j]<target:
                i+=1
            else:
                return True
        return False