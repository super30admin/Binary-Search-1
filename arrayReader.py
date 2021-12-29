#   ques: 702. Search in a Sorted Array of Unknown Size

#   Time Complexity :
#   O(log n)

#  Space Complexity :
#  O(1)

#  Did this code successfully run on Leetcode :
#  Yes

#  Any problem you faced while coding this :
#  No

#  Your code here along with comments explaining your approach

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # taking search window for binary search
        low = 0
        high = 1
        
        # updating search window until the element at higher bound of search window is greater than target element
        while (reader.get(high) < target):
            low = high
            high = high * 2
            
        # applying binary search to the search window in which element may be present
        while (low <= high):
            mid = (low + high)//2
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid +1
        
        # Returning -1 if element not found
        return -1
