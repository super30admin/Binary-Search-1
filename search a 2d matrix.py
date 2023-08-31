class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]:
            return False

        rows, cols = len(matrix), len(matrix[0])

        # Perform a binary search on the flattened matrix
        left, right = 0, rows * cols - 1

        while left <= right:
            mid = left + (right - left) // 2
            mid_value = matrix[mid // cols][mid % cols]

            if mid_value == target:
                return True
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1
