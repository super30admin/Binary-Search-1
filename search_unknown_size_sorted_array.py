'''
Approach: As we dont know the end of the array, for performing binary search, we can take high as difference between target and element at 0th index. This is because, in worstcase, the elements present between 0th index and target will be target-element at 0th index. Now we find mid, and check if target is present at mid. If not at mid, we move towards left if mid element is greater than target or if 2**31 is returned. If element at mid is less than target, we move towards right.

Time complexity:O(log(target-reader(get(0)))
Space complexity: O(1)

Passes all leetcode tests

'''

# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        x = (1<<31)-1
        low = 0
        high = target-reader.get(0)
        while(low<=high):
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid)>target or reader.get(mid) == x:
                high = mid-1
            elif reader.get(mid)< target:
                low = mid + 1
        return -1
        
