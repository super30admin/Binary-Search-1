# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Logic: set an initial range & find whether target is within the range or not. If not then double the range
# finally when we have the range, search for the target element if present return index else return -1

import sys


class Reader:
    def __init__(self):
        self.data = []

    def get(self, index):
        if index < len(self.data):
            return self.data[index]
        else:
            return sys.maxsize


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start = 0
        end = 1
        # search the range of target
        while reader.get(end) < target:
            start = end
            end = 2 * end
        while start <= end:
            mid = start + (end - start)//2
            output = reader.get(mid)
            if output == target:
                return mid
            if target > output:
                start = mid + 1
            else:
                end = mid - 1
        return -1
