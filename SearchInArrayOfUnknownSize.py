# Time Complexity : O(logT) where T is the index of target
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Incremented the end pointer by going on multiplying it by 2 until we found that the target is now within the array and performed binary search on the same.

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):

        end=1
        while reader.get(end)<target:
            end*=2

        start =0

        while start<=end:
            mid=(start+end)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)<target:
                start=mid+1
            else:
                end=mid-1

        return -1
                