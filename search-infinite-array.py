# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start=0
        end=1

        while target > reader.get(end):
            start = end
            end = end*2

        while start <=end:
            mid = start + (end-start)//2
            print(start,mid, end)
            if target == reader.get(mid):
                return mid
            elif target < reader.get(mid):
                end=mid-1
            else:
                start=mid+1

        return -1
