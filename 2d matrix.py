#if we convert the array into linear it takes o(n). instead of converteing into linear
# we are using formula to calculate rows and columns then we are navigating throigh those values

#tc: o(m*n)
#sc: o(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) == 0:
            return False

        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n  - 1
        while low <= high:

            mid = (low + high)//2
            row = mid // 2
            col = mid % n

            if matrix[row][col] == target:
                return True
            else:
                if matrix[row][col] < target:
                    high = mid - 1
                else:
                    low = mid + 1
        return False
