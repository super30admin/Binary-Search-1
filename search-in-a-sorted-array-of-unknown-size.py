# Time Complexity : O(log n), where n indicates the length of the list
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l, r = 0, 1
        while(reader.get(r) < target):
            l = r
            r = 2*r
        
        while l <= r:
            m = l + (r-l)//2
            if reader.get(m) == target:
                return m
            else:
                if target > reader.get(m):
                    l = m + 1
                else:
                    r = m - 1
        return -1