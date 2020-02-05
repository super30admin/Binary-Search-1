class Solution(object):
    def searchUnbounded(self, nums, target):
        """
        Solution:
        1. Double the index of high continuously till element at low index is greater than target.
        2. Perform binary search on the array chunk from low to high and return the appropriate index.

        --- Passed for all indices in [0, 1, 2, 3, 4, 5, 6, 7, 8]
        """
        # O(logn) Time Complexity | O(1) Space Complexity
        low = 0
        high = 1
        while (nums[low] <= target):
            index = self.binarySearch(nums, low, high, target)
            if (index == -1):
                low = high
                high *= 2
            else:
                return index
        return -1

    def binarySearch(self, arr, l, r, x):

        # O (logn) Time Complexity | O (1) Space Complexity

        while (l <= r):  # continually update l or r by checking one of the 3 conditions
            mid = l + int((r - l) / 2)

            if (x == arr[mid]):  # return mid index if found else return -1 if l > r i.e. not found
                return mid

            elif (x < arr[mid]):
                r = mid - 1

            else:
                l = mid + 1

        return -1
