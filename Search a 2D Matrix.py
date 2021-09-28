# time complexity : O(log m + log n)
# space complexity: O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        lo = 0
        hi = m*n-1
        
        while(lo<=hi):
            mid = lo + (hi-lo)//2
            i = mid // n
            j = mid % n
            if matrix[i][j] ==target:
                return True
            elif matrix[i][j] < target:
                lo = mid +1
            else:
                hi = mid -1
        return False