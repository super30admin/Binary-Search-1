# Time Complexity : O(log(T)), where T is the index of the target value
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high + 1
            high = high * 2

        while (low <= high):

            mid = low + (high - low) // 2

            mid_element = reader.get(mid)

            if target == mid_element:
                return mid

            elif target < mid_element:
                high = mid - 1

            else:
                low = mid + 1

        return -1
