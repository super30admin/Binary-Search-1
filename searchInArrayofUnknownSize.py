#O(log2n) time and O(1) solution

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while(reader.get(high) < target):
            low = high
            high = 2 * high
        while(low <= high):
            middle = low + (high - low) // 2
            if reader.get(middle) == target:
                return middle
            elif reader.get(middle) < target:
                low = middle + 1
            else:
                high = middle - 1
        return -1
        