# Time Complexity : O(logn) where n is the size of the array that is searched
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We first find the highest index in our search space by expanding the search space in powers of 2.
# We then perform binary search in that search space in O(logn) time



class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        
        l, h = 0, 1
        while reader.get(h) < target:
            l = h
            h = h*2
        

        while l <= h:
            m = l + (h-l)//2
            val = reader.get(m)
            if val == target:
                return m
            elif val < target:
                l = m + 1
            else:
                h = m - 1
        return -1