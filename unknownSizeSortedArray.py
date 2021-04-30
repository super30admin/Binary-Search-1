"""
Array length is unknown so cannot use length function or for loop (in Java).
Method 1: Use Java Reader Interface and read the entire array. Use while loop. While true --> iterate from i=0 and
search for element. Keep on iterating till we find the element and break or put an exception case if element cannot be
found and array goes out of bound --> O(n)
Method 2: Keep low at 0 and high at index 1. Check if target is within this range and high pointer is not
greater than max value of INTEGER (to avoid array out of bounds exception. It does not matter if high is out of bounds,
as we are concerned with mid. If mid is out of bounds, then change high to mid - 1 and then apply binary search). If
target < high, move high to double the previous high index position (~ to previous high index pointer << 1 or previous
high index pointer * 2^1 (left shift)). Also move low to the previous high position. Do this till target is < high
pointer index value. This will give a range within which the target should be present in the sorted array --> O(logn)
** We don't increase by 3x and above, because although it would reduce the runtime complexity as base of log will
increase, it would greatly increase the range within which we perform binary search, which will again affect the balance
and become inefficient.**
Apply binary search within this range --> O(log(range))
Overall Time Complexity: O(logn) + O(log(range))
Method 3: Make the high point as Integer.MAX or 10^4 which is given as the highest value for length of array.


Method 2:
Runtime Complexity: O(logn) + ~O(log(logn))
Space Compelxity: O(1)

Yes it worked on Leetcode
I am unsure about how to write time complexity of binary search operation i.e. how to express the range. Please check.
"""


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binarySearch(self, reader, low, high, target):
        if low <= high:
            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                return self.binarySearch(reader, low, mid - 1, target)
            else:
                return self.binarySearch(reader, mid + 1, high, target)
        return -1

    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1

        while (target > reader.get(high)):  # logn
            low = high
            high = 2 * high

        return self.binarySearch(reader, low, high, target)  # logn



