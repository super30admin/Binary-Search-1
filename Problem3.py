# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We are using a exponential search to find the upper bounds and dubuling the index until its greater then the target then we proceed with the binary search

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        i = 0
        while reader.get(i) < target:
            i = i * 2 + 1
            if reader.get(i) == 2**31 - 1:
                break

        left, right = 0, i
        while left <= right:
            mid = left + (right - left) // 2
            value = reader.get(mid)

            if value == target:
                return mid
            elif value > target or value == 2**31 - 1:
                right = mid - 1
            else:
                left = mid + 1

        return -1