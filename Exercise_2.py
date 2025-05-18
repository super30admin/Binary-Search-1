# 74. Search a 2D Matrix

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #74
# Any problem you faced while coding this : No

# Approach:
# Consider matrix as 1d array and perform binary search
# row# = x / (Number of columns) and Col# = x % (Number of columns)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n -1
        while low <= high:
            mid = low + (high - low)//2
            rIdx = mid//n
            cIdx = mid%n
            if matrix[rIdx][cIdx] == target:
                return True
            elif matrix[rIdx][cIdx] < target:
                low = mid +1
            else:
                high = mid -1
        return False