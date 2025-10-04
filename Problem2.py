#Search in a sorted array of unknown size
import ArrayReader

class Solution: 
    def search(self, reader: ArrayReader, target: int) -> int:
        #Step 1 is to find the low and high boundaries
        low, high = 0, 1
        #Perform while the value at index high is less than target, initialize low to high 
        #multiply high by 2, the reason why we do that is for balance between time complexity 
        #and ensures we find time complexity of O(log n)
        while(reader.get(high) < target):
            low = high
            high *= 2
        
        while low <= high:
            mid=(low + high)//2
            value = reader.get(mid)
            if(value==target):
                return mid
            elif value < target:
                high = mid - 1
            else:
                low = mid + 1
        return -1 
