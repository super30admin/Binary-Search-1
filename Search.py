# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:


#Time Complexity - o(logn)
#Did this code successfully run on Leetcode : Yes

class Solution:

    def search(self, reader: 'ArrayReader', target: int) -> int:

        i = 5
        result = []

        l = 0
        r = 1

        while reader.get(r)<target:
            l = r
            r *= 2

        while l<=r:
            m = (l+r)//2
            if reader.get(m)==target:
                return m
            if reader.get(m)<target:
                l = m + 1
            else:
                r = m - 1
        return -1


        

        

        