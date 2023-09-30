# time complexity: O(log(m)+log(n)).
# log(m) to find the range between high & low, and log (n) to actually do the binary search
# space complexity: O(1) as no additional space used
# # Did this code successfully run on Leetcode : N/A , needed LC premium
# Any problem you faced while coding this : No

class Solution:
    def search(self, reader, target):
      # sliding window approach. If target is greater than value at high, set low = high & keep doubling high idx until your element at high is greater than target. This is the search range for your BS.
        low, high = 0, 1
        # find search range
        while reader.get(high) < target:
            low = high
            high = 2*high

        # normal binary search once you have the range
        while low <= high:
            mid = low+(high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid-1
            else:
                low = mid+1
        return -1
