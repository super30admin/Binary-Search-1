#Time Complexity=O(logn)
#Space Complexity =O(1)
#// Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

class Solution:
    def search(self, reader, target):
        l, r = 0, 10000
        while l <= r:
            mid = (l+r)//2
            val = reader.get(mid)
            if val == target: return mid
            elif val < target: l = mid+1
            else: r = mid-1 
        return -1
