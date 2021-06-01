# Time Complexity: O(logn)
# Space Complexity = O(1)

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

class Solution(object):
    def search(self, reader, target):
        low = 0
        high = 1

        # Checking if first element is target
        if reader.get(0) == target:
            return 0

        # Finding the range for searching
        while reader.get(high) < target:
            high = high * 2

        #  Using basic binary search on determined searching space
        while low <= high:
            mid = low + (high - low) / 2

            if reader.get(mid) == target:
                return mid

            if reader.get(mid) < target:
                low = mid + 1
            else:
                high = high - 1

        return -1

        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
