# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

#Time Complexity :O(log m +log n) log m for finding the range and log n for the binary search
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low=0
        high=1

        while(reader.get(high)<target):
            low=high
            high=2*high

        while(low<=high):
            mid=int(low+(high-low)/2)
            if reader.get(mid)==target:
                return mid
            elif target<=reader.get(mid):
                high=mid-1
            else:
                low=mid+1
        return -1
