# Time Complexity: O(logm + logn)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: Perform two binary searchs, use the first to locate the potential row that may 
# contains the target value, and then use the second one to look for target value in that row

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False

        rows, cols = len(matrix), len(matrix[0])

        # first binary search to determine the potential row the target locates at
        start, end = 0, rows

        while start < end:
            mid = (start + end) // 2
            if matrix[mid][-1] < target:
                start = mid + 1
            else:
                end = mid

        if start == rows:
            return False

        r = start
        # second binary is to check if target is on that row
        start, end = 0, cols

        while start < end:
            mid = (start + end) // 2
            if matrix[r][mid] >= target:
                end = mid
            else:
                start = mid + 1

        return start < cols and matrix[r][start] == target