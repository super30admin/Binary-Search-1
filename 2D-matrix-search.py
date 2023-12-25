class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1
        while low <= high:
            mid = (low + high) // 2
            r = int(mid // n)
            c = int(mid % n)

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1

        r = int(low / n)
        c = int(low % n)
        if 0 <= r < m and 0 <= c < n and matrix[r][c] == target:
            return True
        else:
            return False
