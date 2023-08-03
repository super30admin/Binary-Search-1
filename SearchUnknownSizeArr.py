#first start with min low and high if target is greater than high then multiply with 2
#search in new bound if value of mid is target value return that if less than mid search left part else right part
class sol:
    def search(self, reader:'ArrayReader',target:int)->int:
        low=0
        high=1
        
        while target>reader.get(high):
            low=high
            high=2*high
            
        return self.binarysearch(reader,target,low,high)
        
    def binarysearch(self,reader:'ArrayReader',target:int,low:int,high:int)->int:
        while low<=high:
            mid=low+(high-low)//2
            val=reader.get(mid)
            if val==target:
                return mid
            elif target>val:
                low=mid+1
            else:
                high=mid-1
        return -1
            