# Time Complexity : log m + log n where m is the high value we get after the first loop and n is the size of the range between low and high that we get after the first loop
# Space Complexity : O(1) as we don't store any data other than basic O(1) variables. 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        
        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high # As target is not available at ot before current high, update low to this high
            high = high*2 # Expand high by doubling the high size. 
        
        # Now we perform binary search starting with the low and high wer get after the above
        while(low <= high):
            mid = low + (high-low) // 2 # Calculate mid element
            if reader.get(mid) == target:
                return mid  # Return mid if target is the mid element
            elif target < reader.get(mid):
                high = mid-1 # If target is less than mid element its in left half of mid
            else:
                low = mid+1 # If target is more than mid element its in right half of mid
        return -1 # Returns -1 if element is not found above