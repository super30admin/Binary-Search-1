#  APPROACH - 1
# Time Complexity : O(lg n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
# 1. First, we need to get the range of elements where we can do Binary Search. Have fast and slow pointers. 
# 2. Each time, check if element at fast < target - If so, stop, the range is between slow and fast
#                                                 - If not update slow to previous fast and fast to fast * 2
# 3. Once we get the range, the do normal Binary Search within the range
# 4. Its similar to the problem - Search in finite sorted array of unknown size, as we don't really bother about the elements after fast pointer once we get the range. 


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        slow_ptr, fast_ptr = 0, 1
        while reader.get(fast_ptr) < target:
            slow_ptr = fast_ptr
            fast_ptr = fast_ptr * 2
            
        start, end = slow_ptr, fast_ptr
        while start <= end:
            mid = start + (end - start) // 2
            element = reader.get(mid)
            if element == target:
                return mid
            elif element > target:
                end = mid - 1
            elif element < target:
                start = mid + 1
                
        return -1
            
