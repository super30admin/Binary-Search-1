# Time Complexity: O(log p)
# Space Complexity: O(1)
# Did this code successfully run on LeetCode: I don't have premium account to check it on Leetcode, but I have tested it

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l, h = 0, 1
        while reader.get(h) < target:
            l = h
            h *= 2
        while l <= h:
            mid = (l + h) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                l = mid + 1
            else:
                h = mid - 1
        return -1