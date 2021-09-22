class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r = len(matrix)
        c = len(matrix[0])
        left = 0
        right = r*c - 1
        while left <= right:
            mid = left + ((right-left)//2)
            row = mid//c
            col = mid % c
            mid_element = matrix[row][col]
            if mid_element == target:
                return True
            elif mid_element > target:
                right = mid - 1
            elif mid_element < target:
                left = mid + 1
        return False
