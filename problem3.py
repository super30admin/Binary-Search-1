
#time-comp-O(logn) 
#space comp-O(1)
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0)==target:
            return 0
        else:
            i=1
            while reader.get(i)<target:
                    i=i*2
            if reader.get(i)==target:
                    return i
            return self.binary_search((i//2)+1,i-1,reader,target)
    def binary_search(self,l,h,reader,target):
        print(l,h)
        while l<=h:
            mid=(l+h)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)>target :
                h=mid-1
            
            else:
                l=mid+1
        return -1
                
                
                    
            
            
            
        
