# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : A little unsure about the Precise Time Complexity
# since we have to search for low and high, would that affect the time complexity

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low:int = 0
        high:int = 1
        # defining the search space to conduct binary seach
        while target > reader.get(high):
            low = high + 1
            high *= 2

        while low <= high:
            mid:int = low + ((high-low)//2)

            if reader.get(mid) > target:
                high = mid - 1
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                return mid
        return -1