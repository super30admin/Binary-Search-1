"""
// Time Complexity : o(log mn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : initially made div and mod by matrix length instead of matrix[0] length


// Your code here along with comments explaining your approach in three sentences only
treat entire matrix as a single array and take first element as low which is 0 and then make last element as hi (which is m*n-1)
corresponding mid = lo + (hi-lo)//2 but we need to convert the mid index into row, column which we do by mid//len(matrix[0]) and mid%len(matrix[0])
"""

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lo = 0
        hi = (len(matrix) * len(matrix[0])) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            mid_x, mid_y = mid // len(matrix[0]), mid % len(matrix[0])
            mid_val = matrix[mid_x][mid_y]
            if mid_val == target:
                return True
            elif mid_val < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False
