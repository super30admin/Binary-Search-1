#  Time Complexity : O(log(m*n))
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach in three sentences only: We consider a flattened 1-D array. We find the midpoint of the array. Find the row and column index of the midpoint of the array. Find the target using Binary Search.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if (matrix is None or len(matrix) == 0):
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1

        while (low <= high):
            mid = low + (high - low) // 2
            r = mid // n
            c = mid % n
            if (matrix[r][c] == target): return True
            if (matrix[r][c] > target):
                high = mid - 1
            else:
                low = mid + 1

        return False