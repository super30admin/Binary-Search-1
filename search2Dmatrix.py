class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        nr, nc = len(matrix), len(matrix[0])
        l, r = 0, nr * nc -1
        
        while l <= r:
            m = l + ((r - l) // 2)
            ele = matrix[m // nc][m % nc]
            if target == ele:
                return True
            elif target > ele:
                l = m + 1
            else:
                r = m - 1
                
        return False
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or matrix == null:
            return False
        
        m, n = len(matrix), len(matrix[0])
        l, r = 0, m*n - 1

        while l <= r:
            m = l + ((r-l)//2)
            ele = matrix[] 