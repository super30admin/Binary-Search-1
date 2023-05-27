# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class ArrayReader:
   def get(self, index: int) -> int:
       
    class Solution:
        def search(self, reader: 'ArrayReader', target: int) -> int:
            low = 0
            high = 1
            while(reader.get(high)<target):
                low = high
                high = high*2
            while(low<=high):
                mid = low+(high-low)//2
                print(low,high,mid)
                if(target==reader.get(mid)):
                    return mid
                elif (target<reader.get(mid)):
                    high = mid-1
                # elif (reader.get(high)==target):
                #      return reader.get(high)
                # elif (reader.get(low)==target):
                #     return reader.get(high)
                else:
                    low = mid+1
            return -1