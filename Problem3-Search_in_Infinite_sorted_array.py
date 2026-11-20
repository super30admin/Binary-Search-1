# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, its a behind a pay wall
# Any problem you faced while coding this : No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        slow = 0
        fast = 1

        while reader.get(fast) < target:
            slow = fast
            fast *= 2

        while slow <= fast:
            mid = (slow + fast) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                slow = mid + 1
            else:
                fast = mid - 1
        return -1
