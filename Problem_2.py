"""
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : I don't have leetcode Premium. I saw the code online and just
wrote down my algo
Any problem you faced while coding this : no

As we do not know the last index, we start from 1 as hih index. We keep on multiplying it unless we find
a value which is greater than target. Once we reach there, we set low as half of high and perform binary search
between them
"""


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        right = 1
        while ArrayReader.get(right) < target:
            right *= 2
        left = int(right/2)

        while left <= right:
            mid = left+(right-low)//2
            if(ArrayReader.get(mid) == target):
                return mid
            if(ArrayReader.get(mid) > target):
                right = mid-1
            else:
                left = mid+1
        return -1
