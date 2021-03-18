class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix:
            return False

        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m * n - 1
        while low <= high:
            mid = low + (high - low) // 2  # integer overflow
            r = mid // n
            c = mid % n

            if matrix[r][c] == target:
                return True

            elif target > matrix[r][c]:
                low = mid + 1

            else:
                high = mid - 1

        return False

matrix_search = Solution()
print(matrix_search.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 16))
print(matrix_search.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 100))
