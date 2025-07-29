#Search a 2D Matrix

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        num_rows = len(matrix)
        num_cols = len(matrix[0])
        # We are considering the 2D matrix as a flattened 1D array and using binary search to find the middle element
        left, right = 0, (num_rows * num_cols) - 1

        while left <= right:
            mid_index = (left + right) // 2
            row = mid_index // num_cols
            col = mid_index % num_cols
            mid_element = matrix[row][col]
            if mid_element == target:
                return True
            elif mid_element > target:
                right = mid_index - 1
            else:
                left = mid_index + 1
        return False