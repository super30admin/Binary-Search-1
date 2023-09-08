# // Time Complexity : O(log(high - low))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        def bsearch(l, r, element):
            while l <= r:
                mid = (l+r)//2
                num= reader.get(mid)
                if num == element:
                    return mid
                if num < element:
                    l = mid + 1
                else:
                    r = mid -1
            return -1

        low, high = 0, 1
        while reader.get(high) < target:
            low = high
            high = high*2
        return bsearch(low, high, target)