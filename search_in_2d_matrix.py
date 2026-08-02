#Time Complexity : O(log m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only

#working mechanism: so basically the idea is to apply binary search without flattining the input matrix. so we would need mapping to always map the mid to the right row and col in the 2d matrix. and this can be derived by using row = mid // n and col = mid % n where n is the number of columns in the matrix. this way we can treat the 2d matrix as a virtual 1d array and apply binary search on it.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1
        while low <= high:
            mid = low + (high - low) // 2
            row = mid // n
            col = mid % n
            if matrix[row][col] == target: return True
            if matrix[row][col] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False 
