class ArrayReader:
    def get(self, index: int) -> int:
        arr = [1,2,5,8,12,16,23,29,55,78,90]
        return arr[index]


class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        
        while (reader.get(high) < target):
            low = high
            high = 2*high
        
        return self.binarySearch(reader, target, low, high)
    
    def binarySearch(self, reader, target, low, high):
        while (low<=high):
            mid = int(low + (high-low)/2)
            
            if (reader.get(mid) == target):
                return mid
            elif (reader.get(mid)>target):
                high = mid - 1
            else:
                low = mid + 1
            
        return -1
    
    # TC: O(log n)
    # SC: O(1)
