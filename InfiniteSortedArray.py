
"""
Exponetially expand the search by twice until we find the range once the range is found do the binary search
"""
#Time Complexity: O(logn)
#Space Complexity: O(1)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Step 1: Exponentially expand the search range
        left, right = 0, 1
        while reader.get(right) < target  and reader.get(right) != 2**31 - 1:
            left = right
            right *= 2
        
        # Step 2: Binary search within the found range
        while left <= right:
            mid = left + (right - left) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            
            if val > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return -1