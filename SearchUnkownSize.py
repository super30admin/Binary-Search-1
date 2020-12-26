'''
    Time Complexity:
        I think it would be O(log(n)) (just because I am following the Binary Search paradigm).
        Tbh, I don't have a very concrete way of evaluating the Complexity of this problem.

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        The approach kind of worked, but I had to hack my way into the solution.
        It took me a couple of hits and trials to satisfy all of LeetCode's tests.

    Approach:
        Following Binary Search paradigm.
        -> Given that accessing reader.get(k) for k >= len(array), it returns 2^31 - 1. So, saved it to a variable.
        -> Assume that the array length almost equal to 100, so low = 0 and high is 100.
        -> Loop while low <= high:
            -> Calculate the mid
            -> If the API returns OUT_OF_BOUNDS for high, that means the array is smaller than the current high,
                -> so set the high = mid
            -> Else:
                -> Get the value at mid.
                -> If the returned value matches the target, return mid
                -> Else if this value is greater than target, look for the value in the left half,
                    -> So, high = mid - 1
                -> Else:
                    -> Check if API hits OUT_OF_BOUNDS for mid + 1:
                        -> This means that the value won't be in the array, so return -1
                    -> Else:
                        Continue in the search in [mid+1: high+mid]
        -> Return -1
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        OUT_OF_BOUNDS = pow(2, 31) - 1
        low = 0
        high = 100

        while low <= high:
            mid = low + (high - low) // 2

            if reader.get(high) == OUT_OF_BOUNDS:
                high = mid
                continue

            mid_val = reader.get(mid)
            if mid_val == target:
                return mid

            if mid_val > target:
                high = mid - 1
            else:
                if reader.get(mid + 1) == OUT_OF_BOUNDS:
                    return -1

                low = mid + 1
                high = high + mid

        return -1
