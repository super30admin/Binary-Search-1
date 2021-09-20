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
        left = 0
        right = 1
        while reader.get(right) < target:
            left = right  # while the target value is greater than the right bound, we shift the
            right <<= 1                       # left, right = right, 2*right
        while left <= right:                  # do a binary search
            mid = left + ((right-left)//2)
            mid_val = reader.get(mid)
            if target == mid_val:
                return mid
            elif target < mid_val:
                right = mid-1
            elif target > mid_val:
                left = mid+1
        return -1
