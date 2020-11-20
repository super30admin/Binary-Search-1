'''
Time Complexity : O(logN)
Space Complexity : O (1) ;since storig only values in constants
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this :
- Was not able to deduce the logic of assigning low and high as the first two elements instantly

# Your code here along with comments explaining your approach
Binary search approach

'''

class ArrayReader:
   def get(self, index: int) -> int:
       a = [-1,0,3,5,9,12]
       return a[index]

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high
            high*=2
            
        while low <=high:
            mid = low +(high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid-1
            else:
                low = mid+1
                
        return -1
                
reader = ArrayReader()
s = Solution()
print(s.search(reader,9))
