# Time Complexity: O(logmn)
# Space Complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        low = 0

        high = (row * col) - 1

        while (low <= high):
            mid = low + (high - low) // 2
            i = int(mid // col)
            j = int(mid % col)
            midele = matrix[i][j]

            if target == midele:
                return True
            elif target < midele:
                high = mid - 1
            else:
                low = mid + 1

        return False