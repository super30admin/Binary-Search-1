# Time Complexity :O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach in three sentences only
# for getting the right/ high pointer, started off r at 1 and l at 0, 
# then doubled r whenever reader.get(r) an element less than target and updated l to r
# we do this to find the window in whicg target mught exist, once we get the window, we do traditional binary search on it to find index of target
class Solution:
    def binary_search(self, l, r, reader, target):
        while l<=r:
            k = (l+r)//2
            if reader.get(k)==target:
                return k
            elif reader.get(k)>target:
                r = k-1
            else:
                l = k+1
        return -1
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 1
        while True:
            if reader.get(r)==target:
                return r
            elif reader.get(r)<target:
                l=r
                r=2*r
            elif reader.get(r)>target:
                return self.binary_search(l,r,reader,target)
