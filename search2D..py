#Time complexity: O(logn)
#Space complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        if m == 0:
            return False
        left = 0
        right = (m*n)-1
        while left<=right:
            idx = (left+right)//2
            mid = matrix[idx//n][idx%n]
            if mid<target:
                left = left+1
            elif mid> target:
                right = right-1
            elif mid == target:
                return True
        return False
            
            