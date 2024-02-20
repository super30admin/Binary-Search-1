# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    """
    Time Complexity: O(1) for all the operations
    Space Complexity: O(1)
    
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    
    Your code here along with comments explaining your approach:
    1. BruteForce: Lineraly search for target by calling reader.get(i) until either 
                index = 0
                while(reader.get(i) == inf or reader.get(i) == target):
                    num = reader.get(index)
                    index += 1
                else:
                    return -1
                return num
        
    Time Complexity: O(n) where n is the number of elements we need to iterate to find the target 
    Space Complexity: O(1)

    2. In this approach we will use a Binary Search as the given array is sorted.
    - Set the low = 0 and high = 1
    - Find the search space in which the target lies so that we can perfrom binary search on that search space
      - To find the search space; move the high pointer 2 times the current index 
        while(reader.get(high) < target):
            low = high 
            high = high * 2
    - Once the search space is found perform the binary search.

    Time Complexity: O(log m * log n) where m is the number of times high pointer iterated to find the search space and 
                                            n is the total number of elements in the search space on which binary search is performed.
    Space Complexity: O(1)

    """

    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high  = 1

        while(reader.get(high) < target):
            low = high 
            high = high * 2
   
        while(low <= high):
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1