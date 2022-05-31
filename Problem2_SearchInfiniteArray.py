'''
Time Complexity: O(logn)
Space Complexity: O(1)
Submitted on leetcode successfully
'''
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low,high = 0,1
        while(reader.get(high) < target):
            low = high
            high = 2*high
        while(low <= high):
            mid = low + (high - low)//2
            if (reader.get(mid) == target):
                return mid
            elif (reader.get(mid) > target):
                high = mid - 1
            elif (reader.get(mid) < target):
                low  = mid + 1
        return -1
