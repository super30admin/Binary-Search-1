#Time Complexity : log2m + lpng2(n)
# find the space where target can reside which is log2m
#log n is do binary search on space we got
#Space Complexity 0(1)
#Did this code successfully run on Leetcode : yes
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = 2 * low

        while low <= high:
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid + 1
            else:
                high = mid - 1
        return -1

