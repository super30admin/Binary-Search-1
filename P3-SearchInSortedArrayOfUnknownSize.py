"""
Approach: As we dont have the length of the array, we will put our low and high pointers in such a way that out target is in between those pointers, for that we will
run a while loop will when that cindition is satisifed and we will get our low and high pointers and now we will simply binary search through it.

Time Complexity : log(m) + log(n), where m = range of values, n is binary search
Space Complexity : O(1)
"""

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