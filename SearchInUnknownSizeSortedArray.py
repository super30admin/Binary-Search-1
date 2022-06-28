# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity : O(log(n))
# Space Complexity : O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l, r = 0, 1
        count=1 # to decide the power of 2
        # find high value by comparing the index value to the target
        while target > reader.get(r):
            r=2**count*r
            count = count+1
        #binary search    
        while l <= r:
            mid = l + (r - l) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            elif val < target:
                l = mid + 1
            else: 
                r = mid - 1
        return -1