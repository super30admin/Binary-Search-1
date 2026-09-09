'''
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
Approach: To determine where to place high pointer, we start high with 1st index and increase search space by 2 each time array[high] < target condition. Then perform binary search.
'''


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while(target > reader.get(high)):
            low = high
            high = high * 2
        while(low<= high):
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1