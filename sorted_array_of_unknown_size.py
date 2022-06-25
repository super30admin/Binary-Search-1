# Time Complexity : O(log(n)) as we are using binary search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Implementing Search in Sorted Array of Unknown size
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0 # initialising lower and upper bounds [0,1]
        right = 1
        if reader.get(left) == target :
            return left
        if target == reader.get(right):
            return right
        while target > reader.get(right): # If target is not in any of the two bounds then [0,1, *,*,*,*]
            left = right
            right *= 2 # right element will be twice of previous index
        while left <= right: #binary search
            mid = left + ((right - left) // 2) # To avoid integer overflow
            if target == reader.get(mid):
                return mid # Element found
            elif target > reader.get(mid):
                left = mid + 1
            else:
                right = mid - 1
        return -1 # target not found
