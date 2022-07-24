# Time Complexity : log(mn) or log(m) + log(n)
# Space Complexity : log(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, I took no of rows instead of columns(mentioned below)

# Approach is Pretty Simple,consider the matrix as sorted array and access the index using calculations

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) - 1
        while low <= high:
            mid = low + ((high - low) // 2)
            (m_index, n_index) = (mid // n, mid % n)  # Here I miscalculated and got index out of bound
            if matrix[m_index][n_index] == target:
                return True
            elif matrix[m_index][n_index] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False


if __name__ == "__main__":

    # Test Case 1
    matrix_ = [[1, 1]]
    target_ = 1

    # Test Case 2
    # matrix_ = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    # target = 11
    print(Solution().searchMatrix(matrix_, target_))
