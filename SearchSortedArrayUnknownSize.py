# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Don't have Leetcode Premium
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Used Binary Search but since we dont know the size of the Array the right is initialized to 1
# Then extend the right boundary if right < target and performing Binary Search once we get the left and right boundaries


class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        left = 0
        right = 1
        while reader.get(right) < target:
            left = right
            right = right * 2

        while left <= right:
            mid = left + (right - left) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                right = mid - 1
            else:
                left = mid + 1

        return -1
