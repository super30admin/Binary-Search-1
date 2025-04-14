# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
#Time complexity: O(logn)
#Space complexity: O(1)
class Solution:
    def search(self, reader, target):
        low,high=0,1
        while reader.get(high)<=target:
            low=high
            high=2*high
        while low<=high:
            mid=(low+high)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low=mid+1
            else:
                high=mid-1
        return -1
        
        