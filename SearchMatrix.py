# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Getting the length of the first layer to get m
        m = len(matrix)
        # No 2D Matrix
        # Return False if no Matrix
        if m == 0:
            return False
        # Getting the length of the second layer to get n
        n = len(matrix[0])
        # Initialize start and end
        start = 0
        end = m * n - 1
        # Perform Binary Search
        while start <= end:
            pivot = (start + end) // 2
            pivot_elem = matrix[pivot // n][pivot % n]

            if target == pivot_elem:
                return True
            else:
                if target < pivot_elem:
                    end = pivot - 1
                else:
                    start = pivot + 1
        return False
