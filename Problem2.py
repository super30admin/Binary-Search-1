# // Time Complexity: O(logn)
# // Space Complexity: O(1)
# // Did this code successfully run on Leetcode: Yes
# // Any problem you faced while coding this: No

# Solution for https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l = 0
        u = 1

        while reader.get(u) < target:
            l = u
            u *= 2

        while(l <= u):
            mid = l+(u-l)//2
            el = reader.get(mid)
            if el == target:
                return mid
            else:
                if el < target:
                    l = mid+1
                else:
                    u = mid-1
        return -1
