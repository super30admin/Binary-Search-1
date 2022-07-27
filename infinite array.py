#time complexity - O(log(n))
#space complexity - O(1)
#solution ran on leetcode successfully
#no problems during coding

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        
        while(reader.get(high) < target):
            low = high
            high = 2*high
        
        while(low <= high):
            mid = low + (high - low) // 2
            if(reader.get(mid) == target):
                return mid
            elif(reader.get(mid) > target):
                high = mid-1
            else:
                low = mid + 1
        
        return -1