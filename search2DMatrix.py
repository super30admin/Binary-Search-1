# Time Complexity : O(log m+log n)
# Space Complexity : O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l, r = 0, len(matrix) - 1
        while r - l + 1 > 1:  # Binary column search
            mid = (l + r) // 2
            if matrix[mid][0] > target:
                r = mid - 1
            elif matrix[mid][0] < target:
                l = mid + 1
            else:
                return True

        if matrix[l][0] > target:  # Check for special case
            if l > 0:
                l -= 1
        row = l

        l, r = 0, len(matrix[0]) - 1
        while r - l + 1 > 1:  # Binary row search
            mid = (l + r) // 2
            if matrix[row][mid] > target:
                r = mid - 1
            elif matrix[row][mid] < target:
                l = mid + 1
            else:
                return True

        return matrix[row][l] == target



