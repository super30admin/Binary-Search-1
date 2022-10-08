# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 10
        while(target>reader.get(high)):
            low = high + 1
            high = high * 2

        while(low <= high):
            mid = low + (high-low) // 2
            mid_elem = reader.get(mid)

            if (target == mid_elem):
                return mid
            elif target < mid_elem: #handles out of bound
                high = mid - 1
            else:
                low = mid + 1
        return -1