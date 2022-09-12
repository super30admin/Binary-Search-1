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

# Leetcode submission successful.
class Solution(object):

    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # logarithmic time so binary search. Space Complexity: O(1).
        lo = 0
        hi = 1

        # A technique we are using that seems to be very optimal.
        while (reader.get(hi) < target):
            lo = hi
            hi *= 2
        return self.bin_search(lo, hi, target, reader)

    def bin_search(self, low, hig, target, reader):
        while (low <= hig):
            mid = low + (hig - low) / 2  # to prevent integer overflow
            if reader.get(mid) == target:
                return mid
            else:
                if reader.get(mid) > target:
                    hig = mid - 1
                else:
                    low = mid + 1
        return -1