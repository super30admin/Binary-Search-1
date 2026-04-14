class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        low, high = 0, 1
        while target > reader.get(high):
            low = high
            high = high << 1
        while low <= high:
            mid = low + (high - low) // 2
            curr = reader.get(mid)
            if curr == target:
                return mid
            if target < curr:
                high = mid - 1
            else:
                low = mid + 1
        return -1