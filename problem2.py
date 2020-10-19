// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution(object):
    
    def binary_search(self,arr,target,low,high):
        mid=0
        
        while(low<=high):
            mid=low+(high-low)/2
            print(arr.get(mid))
            if arr.get(mid)==target:
                return mid
        
            elif arr.get(mid)<target:
                low=mid+1
        
            elif arr.get(mid)>target:
                high=mid-1
            
        return -1
    
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
    
        
        low=0
        high=1
        
        while(low<=high):
            
            if reader.get(high)<target: #checking id target lies in the range
                low=high
                high=2*high     
            else:
                return(self.binary_search(reader,target,low,high))
