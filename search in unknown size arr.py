# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
#Time: O(log(n))
#Space: O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l=0
        h=1
        lv=reader.get(l)
        hv=reader.get(h)
        while reader.get(h)<target:
            l=h
            h*=2
            
        while(l<=h):
            mid=(l+h)//2
            if reader.get(mid)<target:
                l=mid+1
            elif reader.get(mid)>target:
                h=mid-1
            else:
                return mid
        
        
        return -1
                    
