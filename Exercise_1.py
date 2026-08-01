# https://leetcode.com/problems/search-a-2d-matrix/description/

# Time complexity: O(log n)
# Space complexity: O(1)

# Explanation: Perform binary search and treat the matrix as an array that has been stretched out

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            r = mid // n
            c = mid % n

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1

        return False
        
