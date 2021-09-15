# Time complexity: O(log n) for binary search, for defining the boundaries O(log k) where k is the index of the target?
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0) == target:
            return 0

        left, right = 0, 1

        while reader.get(right) < target:
            left = right
            right = right*2

        while left <= right:
            mid = left+(right-left)//2
            elem = reader.get(mid)
            if elem == target:
                return mid
            if elem < target:
                left = mid+1
            else:
                right = mid-1
        return -1
