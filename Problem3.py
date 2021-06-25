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
        low=0
        high=1
        #First find the range where the element exists
        #traverse till target greater than high value,set low to high+1 and high to high*2
        #so, we are doubling the search space and but also skipping elements
        while(reader.get(high)<target):
            low=high
            high=high*2
        
            
        return self.binarySearch(low,high,target,reader)
    def binarySearch(self,start,end,target,reader):
        while(start<=end):
            mid=(start+end)//2
            if reader.get(mid)==target:
                return mid
            elif  reader.get(mid)>target:
                end=mid-1
            else:
                start=mid+1
        return -1
    
                    
            
      #https://leetcode.com/submissions/detail/512877437/ 
      #Time Complexity: O(log n)
      # Space O(1)
