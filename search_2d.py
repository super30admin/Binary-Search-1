# Time complexity O(log(n))
class Solution(object):
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) - 1
        while low <= high:
            mid = low + (high - low) // 2
            midVal = matrix[mid // n][mid % n]
            if midVal == target:
                return True
            elif midVal > target:
                high = mid - 1
            elif midVal < target:
                low = mid + 1
        return False 