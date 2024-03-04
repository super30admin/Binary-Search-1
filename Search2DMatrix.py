# Time Complexity : O(log(m * n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        Rows = len(matrix)
        Cols = len(matrix[0])

        low = 0
        high = (Rows*Cols) - 1

        while low <= high:
            
            mid = low + (high - low) // 2

            r = mid // Cols
            c = mid % Cols

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] <= target:
                low = mid + 1
            else:
                high = mid - 1
        return False