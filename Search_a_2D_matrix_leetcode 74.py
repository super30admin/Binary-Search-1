class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        # Best : Time complexity O(log(m*n))
        # space complexity O(1)
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = n * m - 1
        while left <= right:
            mid = (left + right) // 2
            mid_element = matrix[mid // n][mid % n]
            # row = mid//n and col = mid % n
            if target == mid_element:
                return True
            elif target < mid_element:
                right = mid - 1
            elif target > mid_element:
                left = mid + 1
        return False
