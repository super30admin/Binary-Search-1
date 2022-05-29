# Time Complexity : log(N) + log(M), first log N is for finding the range of numbers in the given array, once we find it log M is to find target in that range with binary search. 
# Space Complexity : O(1) no extra memory allocated, only constant variables are used
# 702. Search in a Sorted Array of Unknown Size

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0 
        high = 1
        while target > reader.get(high):
            low = high
            high *= 2
            
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1

