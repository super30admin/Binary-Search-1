# Time Complexity : It is O(log n) since we dividing the length in each iteration. 
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while(reader.get(high)<=target):
            low=high
            high=high*2
        
        
        while(low<=high):
            mid= low +(high-low)//2
            
            if(reader.get(mid)==target):
                return mid
            elif (reader.get(mid)>target):
                high=mid-1
            else:
                low=mid+1
        return -1
    
obj = Solution()
print(obj.search([-1,0,3,5,9,12],9))