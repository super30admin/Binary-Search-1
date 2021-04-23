class Solution:
    def binarysearch(self,reader,low,high,target):
        while low <= high:
            mid = low + (high-low)/2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid +1 
            else:
                high = mid - 1
                
    
    def search(self,reader,target):
        low = 0 
        high = 1
        while(target < reader.get(high)):
            low = high 
            high = 2*high

        return binarysearch(reader,low,high,target)