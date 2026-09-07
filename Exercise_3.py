'''
Time Complexity :
O(log n)

Space Complexity :
O(1)

Did this code successfully run on Leetcode :

Yes

Conceptual Approach:

Since we can distinguish between an invalid index, and an array value as per the constraints, what we should try to do is determine whether or not
our target is within our search range. Setting our low = 0, and high = 2, we will do this in two parts:

1. Expand our range until our target value is potentially inside of it
2. Conduct binary search until we find our value or see that it does not exist

Edge Cases:

- Target does not exist
We cannot continue the first part of our algorithm unbounded, because the target will never exist
- Value exists in the boundary of the array -> This is much easier to deal with because of how the interface works.
- Single value array

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- The interface will return 2^31 -1 if the index you are querying is out of the boundary of the array
This is a huge hint that we should conduct a binary search by expanding our high index beyond the bounds of the size of the array

- 1 <= secret.length <= 10^4
In conjunction with the previous constraint, this allows us to distinguish between non-existent values / invalid indices and actual values in the array
Additionally there will be no 0 element case.

-10^4 <= secret[i], target <= 10^4

- secret is sorted in a strictly increasing order.
We do not have any repeated values!

Any problem you faced while coding this:
- The edge case where the target does not exist was not handled by the first part of my algorithm and hence was initially an infinite loop
'''
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

OUT_OF_BOUNDS_VALUE = (2**31) - 1

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        # Step 1: Expand our boundary until we find the target is in range
        while not (reader.get(low) <= target <= reader.get(high)):
            if reader.get(low) == OUT_OF_BOUNDS_VALUE:
                return -1
            low = high
            high = high * 2

        # Step 2: Perform binary Search
        while low <= high:
            # We always do this to avoid integer overflow - technically doesn't exist in Python but is a good habit
            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
        