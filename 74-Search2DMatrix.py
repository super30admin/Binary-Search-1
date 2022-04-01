#Time Complexity : O(log mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1

        while (low <= high):
            mid = (low + high) // 2
            row = mid // n
            col = mid % n 

            if matrix[row][col] == target:
                return True
            else:
                if target < matrix[row][col]:
                    high = mid - 1
                else:
                    low = mid + 1
        return False



