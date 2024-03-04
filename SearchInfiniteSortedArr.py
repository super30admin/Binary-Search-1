# // Time Complexity : log(m) + log(n), where m = range of values, n is binary search
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : No it's a leetcode premium problem
# // Any problem you faced while coding this : None

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        if (reader.get(0) == target): 
            return 0
        low = 0
        high = 1
      #get the range of the array
        while reader.get(high) < target:
            low = high
            high = 2 * high
      #Regular binary search
        while low <= high:
            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                high = mid - 1
            elif target > reader.get(mid):
                low = mid + 1
        return -1