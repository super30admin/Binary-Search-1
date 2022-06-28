#class ArrayReader:
#    def get(self, index: int) -> int:
# Time Complexity: O(logn)
# Space Complexity : O(1)
# Did the code run successfully on leetcode: yes
# Any problems faced: None

class Solution:
    # Search in array of Unknown size
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high  = 1
    # 
        while target > reader.get(high):
            low = high
            high = high * 2
            if reader.get(high) == target:
                return high
            
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1
                