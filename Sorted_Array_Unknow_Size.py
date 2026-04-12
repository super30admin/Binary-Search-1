# Time Complexity : O(log n)
# Space Complexity : O(1) - storing only variables.
# Did this code successfully run on Leetcode : No - premium subscription.
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach in three sentences only
#Until high is less than target or get out of bounds keep incresing it 2 times of low to get a range of numbers.
#Once range is found apply binary search to find the target.

class ArrayReader(object):
    def __init__(self, arr):
        self.data = arr

    def get(self, index):
        if index < len(self.data):
            return self.data[index]
        else:
            # LeetCode returns 2^31 - 1 for out-of-bounds access
            return 2147483647

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low, high = 0, 1
        while reader.get(high) < target:
            low = high
            high = high * 2
        while low <= high:
            mid = low + (high-low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

# --- Local Testing Block ---
if __name__ == "__main__":
    # Example usage:
    test_data = [-1, 0, 3, 5, 9, 12]
    target_val = 9
    
    reader = ArrayReader(test_data)
    sol = Solution()
    print(f"Result: {sol.search(reader, target_val)}")