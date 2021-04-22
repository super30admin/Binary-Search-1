class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0) == target:
            return 0

        # create serach boundary
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right <<= 1

        while left <= right:
            mid = left + (right - left) // 2

            if reader.get(mid) == target:
                return mid

            if reader.get(mid) > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

#
# untime: 32 ms, faster than 17.44% of Python online submissions for Search in a Sorted Array of Unknown Size.
# Memory Usage: 14.6 MB, less than 12.31% of Python online submissions for Search in a Sorted Array of Unknown Size.