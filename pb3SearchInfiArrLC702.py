# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

"""
    Approach 
        We are starting with 1 as right index while 0 as left index because we dont know size
        keep multiplying right by 2 and setting left to right until we have target in range of (right and left)
        at this point this becomes a bounded array and normal binary search operation by finding middle.
    
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l, r = 0, 1
        while l <= r:
            while target > reader.get(r):
                l, r = r, r*2
            m = (l+r)//2
            if reader.get(m) > target:
                r = m-1
            elif reader.get(m) < target:
                l = m+1
            else:
                return m
        return -1
    


