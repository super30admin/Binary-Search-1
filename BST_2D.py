#Time Complexity O log(mn)
# space complexity o(1)


class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) - 1

        if len(matrix) == 0:
            return False
        while (low <= high):
            mid = (low + high) // 2
            r = mid // n
            c = mid % n

            if target == matrix[r][c]:
                return True

            elif target < matrix[r][c]:
                high = mid - 1
            else:
                low = mid + 1

        return False