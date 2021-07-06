# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Don't have a premium subscription :(
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution(object):
    def search(self, reader, target):
        # low and high pointers to read from data stream
        low = 0
        high = 1
        # until high value hasn't gone above target, keep reading
        while(reader.get(high) < target):
            low = high
            high = 2 * high
        # call binarySearch once we have the range of the array which has the target
        return self.binarySearch(reader, target, low, high)

    def binarySearch(self, reader, target, low, high):
        while low <= high:
            mid = low + (high-low) / 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
