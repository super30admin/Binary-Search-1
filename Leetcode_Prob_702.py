#time complexity: O(logn)
#space complexity: O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while reader.get(low) <= target:
            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid

            if target >= reader.get(low) and target <= reader.get(high):
                if target <= reader.get(mid):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                low = high
                high = high * 2

        return -1