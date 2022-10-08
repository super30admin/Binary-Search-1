# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])

        # binary search
        l, r = 0, m * n - 1
        while l <= r:
                pivot_id = (l + r) // 2
                pivot_element = matrix[pivot_id // n][pivot_id % n]
                if target == pivot_element:
                    return True
                else:
                    if target < pivot_element:
                        r = pivot_id - 1
                    else:
                        l = pivot_id + 1
        return False