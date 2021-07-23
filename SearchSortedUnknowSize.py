"""
Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
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
            left = right
            right = right * 2
        # Now that we have found the window where
        # target can potentially be, we just do 
        # a binary search
        while left <= right:
            mid = (left + right)// 2
            if reader.get(mid) == target:
                return mid
            else:
                if target < reader.get(mid):
                    right = mid - 1
                else:
                    left = mid + 1
        return -1
        