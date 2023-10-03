#TC: O(r-l) (total elements in which we needs to do binary search) SC:O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l=0
        r=1

        while reader.get(r)<target:
            l=r
            r=r*2

        while(l<=r):
            mid=(l+r)//2
            if reader.get(mid)==target:
                return mid
            if reader.get(mid)>target:
                r=mid-1  
            else: 
                l=mid+1

        return -1           

         
        low = 0
        high = 1
        
        # as long as high index element still < target incraese the scope of range 
        while reader.get(high) < target:
            low = high + 1
            high = high * 2
        
        # now with this range find element
        while low <= high:
            mid = low + (high-low) // 2
            if reader.get(mid) == target:
                return mid
            
            elif reader.get(mid)>target:
                high = mid-1
            else:
                low = mid+1
                
        return -1   
