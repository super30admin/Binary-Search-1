class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        while reader.get(high) < target:
            low = high
            high *= 2

        while low < high:
            mid = low + (high - low) // 2
            if reader.get(mid) >= target:
                high = mid
            else:
                low = mid + 1

        if reader.get(low) == target:
            return low
        return -1