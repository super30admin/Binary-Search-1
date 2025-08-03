# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# Just assume this works:
# reader.get(index: int) -> int

class ArrayReader:
    def __init__(self, data):
        self.data = data
    
    def get(self, index: int) -> int:
        if 0 <= index < len(self.data):
            return self.data[index]
        return float('inf')  # simulate infinite array

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # First find a range (exponential search to find bounds)
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right *= 2
        
        # Then binary search within that range
        while left <= right:
            mid = (left + right) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return -1


reader = ArrayReader([1, 3, 5, 7, 9, 12, 15, 18])
sol = Solution()
target = 9
print(sol.search(reader, target)) 


#   Time Complexity: O(log T), where T is the index of the target

# Space Complexity : O(1) — no extra space used beyond variables

# Did this code successfully run on Leetcode : Yes, 702 (Search in a Sorted Array of Unknown Size)

# Any problem you faced while coding this :
#   Yes — initially used float division (/) which caused a TypeError due to float index.
#   Fixed it by switching to integer division (//).
#   Also learned to use exponential expansion to find a suitable right boundary.