# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this :


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        outOfBounds = 2147483647
        if (reader.get(0) == outOfBounds):
            return -1

        if (reader.get(0) == target):
            return 0

        left = 0
        right = 1

        while reader.get(right) < target:
            left = right
            right *= 2

        while left <= right:
            mid = (left + right) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                right = mid - 1
            elif reader.get(mid) < target:
                left = mid + 1

        return -1
