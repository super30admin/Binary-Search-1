#Time Complexity: O(log(m*n))
#Space Complexity: O(1)
#Successfully ran on leetcode
class Solution:
    def searchMatrix(self, matrix: list(list(int)), target: int) -> bool:
        if len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n - 1
        while low<=high:
            mid = (low+high)//2
            row = mid // n
            col = mid % n
            if matrix[row][col] == target:
                return True
            elif target > matrix[row][col]:
                low = mid+1
            elif target < matrix[row][col]:
                high = mid-1
        return False