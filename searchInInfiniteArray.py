'''
In this problem, since we don't know the array size, we will keep track of
array window using low and high pointer. Initially we will point low = 0 and high =1
, and then we will exponentially(power of 2) keep increasing the array window
until reader.get(high) < target.
Once we get low and high position, we apply binarySearch in that range.
Time Complexity : O(logN) + O(log M)
N: when finding the window
M: no. of elements in the window. (The one to which we apply Binary Search)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No.
'''


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

    def binarySearch(self, reader, target, low, high):
        while low <= high:
            mid = low + (high - low) / 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        while (reader.get(high) < target):
            low = high
            high = high * 2

        return self.binarySearch(reader, target, low, high)

