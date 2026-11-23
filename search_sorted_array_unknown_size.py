# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
# Approach (3 sentences only):
#

from typing import Callable, Dict, Iterator, List, Optional, Tuple


# LeetCode provides the ArrayReader interface:
#   reader.get(index) -> int   (returns 2**31 - 1 if index is out of bounds)


class Solution:

    def search(self, reader: "ArrayReader", target: int) -> int:
        low = 0
        high = 1

        while reader[high] <= target:
            low = high
            high = 2 * high

        while low <= high:
            mid = (low + high) // 2
            if reader[mid] == target:
                return reader[mid]
            elif reader[mid] < target:
                high = mid - 1
            else:
                low = mid + 1

