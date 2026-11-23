#Problem 1
#Using binary search method. Convert 2D matrix into 1D array.
#T: O(log m*n)
#S: O(1)


class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        l, r = 0, rows*cols - 1

        while l <= r:
            mid = (l + r) // 2
            row = mid // cols
            col = mid % cols

            if matrix[row][col] < target:
                l = mid + 1

            elif matrix[row][col] > target:
                r = mid - 1

            else:
                return True

        return False
