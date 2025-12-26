"""
// Time Complexity : o(log(n) + log(m))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
We need to do binary search but hi is unknown as the array is unknown
To find hi, we start with lo=0 and hi=1 and find if element at hi index is int_max, higher than target or lower than target,
if lower than target, double the search space i.e make lo = hi and hi = hi*2
we keep doubling search space till we get a hi value that is greater than target, once we get hi and low we do binary search
"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        lo = 0
        hi = 1
        while reader.get(hi) < target:
            lo = hi
            hi = hi * 2
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            elif val < target:
                lo = mid + 1
            else:
                hi = mid - 1

        return -1
