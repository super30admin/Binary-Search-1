'''
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 1

        while reader.get(r) < target:
            l = r
            r *= 2
        
        while l <= r:
            mid = l + (r - l) // 2
            if reader.get(mid) == target: return mid

            if reader.get(mid) > target:
                r = mid - 1
            else:
                l += 1

        return -1