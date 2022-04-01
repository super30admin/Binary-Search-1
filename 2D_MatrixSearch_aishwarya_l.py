from typing import List
"""
The time complexity is of binary search where N is m*n, as if the 2D array was flattened out : O(m*n)
Space complexity is O(1)
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # base case:
        if len(matrix) == 0:
            return False

        low = 0
        m = len(matrix)
        n = len(matrix[0])
        high = (m * n) - 1

        while low <= high:
            mid = (low + high) // 2  # in Java,C++ handle integer over flow iwth low+ (high-low)/2

            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False

    matrix=[[-10],[-7],[-5]]
    target = -10
    bool = searchMatrix(matrix=matrix, target=target)
    print(bool)
