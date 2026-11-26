# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
# Time Complexity : O(log n) - each step discards the half that cannot contain the target
# Space Complexity : O(1) - only low, high, mid are used

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low =0
        high = 1 
        while reader.get(high)<target:
            low =high
            high = 2*high
        while low<=high:
            mid = (low+high)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid) > target:
                high = mid-1
            else:
                low = mid+1

        return -1
        