# Time Complexity : o(log n) to get the search space we are exponentionaly increasing the high.
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high)<target:
            high = high*2       # exponentialy increases high to reach a search space that has the target
        low = high//2           #to decrease search space
        while (low<=high):
            mid = (low+(high-low)//2)
            if (reader.get(mid)==target):
                return mid
            elif (reader.get(mid)<target):
                low = mid+1
            else:
                high = mid-1
        return -1