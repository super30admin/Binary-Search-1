class Solution(object):
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) - 1
        if len(matrix) == 0:
            return False
        while low <= high:
            mid = (low + high) // 2
            rows = mid // n
            cols = mid % n
            mid_element = matrix[rows][cols]
            if target == mid_element:
                return True
            elif target <= mid_element:
                high = mid - 1
            else:
                low = mid + 1
        return False