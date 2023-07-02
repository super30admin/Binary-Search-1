# // Time Complexity : O(log m base x + log k base 2), where m is number of times "high" is changed, x is the multiplier factor of "high" and k is the number on eements on which Binarys earch is performed.
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach in three sentences only
# Intially, we set low=0 and high=1 and then we double high and set low to previous value of high till our high becomes more than the target elements.
# Now, at this point we have a reduced range of elements, and now apply binary search to find the target element.


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if not reader: return -1

        low=0
        high=1

        while reader.get(high)<target: 
            low=high
            high*=2
        
        while low<=high:
            mid=low+(high-low)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid)>target:
                high=mid-1
            else:
                low=mid+1
        return -1