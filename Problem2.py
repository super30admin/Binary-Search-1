class Solution:
    # Time Complexity: O(log m*n)
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None:
            return false
        m, n = len(matrix), len(matrix[0])
        low = 0
        high = m * n - 1
        while low <= high:
            mid = int(low + (high - low) / 2)
            r, c = int(mid / n), int(mid % n)
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
