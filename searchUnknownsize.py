#Time complexity: O(logn)
#Space complexity: O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low =high
            high = high*2
        # high = reader.get(high)
        
        while low<=high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid+1
            else:
                high = mid -1
        return -1
            