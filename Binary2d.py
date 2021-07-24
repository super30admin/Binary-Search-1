# Time Complexity : O(log(m) + log(n) )
# Space : O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None:
            return False
        low = 0
        m = len(matrix)
        n = len(matrix[0])
        high =  m * n -1
        
        while low <= high :
            mid = (high + low ) // 2#int(low + ((high- low)/2))
            r = mid // n
            c = mid % n
            cur = matrix[r][c]
            if target == cur:
                return True
            elif cur > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
