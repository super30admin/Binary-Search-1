// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#I have used Binary Search where the high is at 1 index initially and if high is less than target move low to high and high to 2 times high to find the array with high pointer
#I did the binary search once I had low and high


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1