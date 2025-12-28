''' Time Complexity : O(log n)
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : 1. initialize low and high to 0 and 1 respectively.
             2. Double the high variable unil array[high] > target, and updating low to high 
                meaning finding the range where target lies.
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l, h = 0, 1
        while (reader.get(h) < target):
            l = h
            h = h * 2
        
        while l <= h:
            m = (l+h) // 2
            if reader.get(m) == target:
                return m
            elif reader.get(m) <  target:
                l = m + 1
            else:
                h = m - 1
        return -1

        