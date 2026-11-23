# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
# Approach (3 sentences only):
#

from typing import Callable, Dict, Iterator, List, Optional, Tuple


class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        low = 0
        m = len(matrix) 
        n = len(matrix[0])
        high = m * n -1

        while low <= high:
            mid = (low + high) // 2
            r = mid//n
            c = mid%n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False