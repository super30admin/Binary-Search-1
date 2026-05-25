'''
We start with a search size of 1 and see if the array of search space can contain the target.
If not we move the search window to high and move the high to 2*high meaning increase the search window by
2 times.

Once we get the search window where the target lies, we then do a binary search in the window to get the index.
'''

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
