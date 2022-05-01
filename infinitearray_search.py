class Solution:
    '''O(logn) time complexity
        O(1) Space complexity'''
    def search(self,reader:ArrayReader, target: int) -> int:
        low=0
        high=len(reader)-1
        #find the range in which target lies
        while reader.get(high)<target:
            low=high
            high=2*high
        
        #after finding range do binary search
        while low<=high:
            mid=low+(high-low)//2
            if reader.get(mid)==target:
                return mid
            if reader.get(mid)>target:
                high=mid-1
            else:
                low=mid+1
                    