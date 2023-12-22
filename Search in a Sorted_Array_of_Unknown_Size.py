#Time Complexity: O(log n)
# Space Complexity: O(1)


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1  

        while target > reader.get(high):
            low = high
            high = high * 2

        while low <= high:  
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                high = mid - 1
            else:
                low = mid + 1

        return -1
        
        
        