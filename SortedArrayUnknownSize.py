# // Time Complexity : O(logn)
# // Space Complexity : O(1)


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0 
        high= 1
        while reader.get(high) < target:
            low = high
            high = 2*high
        return self.binarySearch(reader, target, low, high)

    def binarySearch(self, reader, target, low, high):
        while low<=high:
            mid = low(high-low)//2
            value = reader.get(mid)
            if target == value:
                return mid
            if target > value:
                low = mid +1
            else: 
                high = mid-1
        return -1