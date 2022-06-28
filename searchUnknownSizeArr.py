# n = range = high - low
# Time Complexity = O(log n)
# Space Complexity = O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        # Keep incrementing the low and high  val, until target lies in that range
        while (target > reader.get(high)):
            low = high
            high = 2 * high
        
        while(low <= high):
        
            mid = low + ((high - low) // 2)
            if target == reader.get(mid):           # if middle eleemnt is target
                return mid
            elif target < reader.get(mid):          # Move left
                high = mid - 1
            else:                                   # Move right
                low = mid + 1
        return -1