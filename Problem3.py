# Problem3:Search in Infinite sorted array:https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
#Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
# Time Complexity: O(log n), Even though we do not know the size of the array upfront, we double the high pointer until it goes past where the target could be. This doubling only takes O(log n) steps.
# After that we do a normal binary search which is also O(log n). Doing both one after another is still O(log n) overall.
# Space Complexity: O(1),We only keep a few variables like low, high and mid. No extra data structures are used.
# Approach:
# Since we do not know the array size, we cannot set high to len(nums) - 1 like usual.
# Instead we start with a small window and keep doubling the high pointer until the value at high becomes greater than or equal to target, or we hit the out of bounds sentinel value.
# Once we have a valid range where the target could exist, we run a normal binary search inside that range to find the exact index.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Start with a small window, low at 0 and high at 1
        low, high = 0, 1

        # Keep doubling high until the value there is no longer smaller than target
        # This grows our search window exponentially so it only takes log n steps to find a valid range
        while reader.get(high) < target:
            # Move low up to where high currently is, since everything before that is confirmed too small
            low = high
            # Double high to expand the window further right
            high *= 2

        # Standard binary search but using strict < so the loop stops one step early
        # This is intentional, see the check right after the loop
        while low < high:
            # Find the middle index of the current range
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                # Found the target exactly at mid, return it right away
                return mid
            if reader.get(mid) > target:
                # Middle value is too big, target must be to the left, shrink high
                high = mid - 1
            else:
                # Middle value is too small, target must be to the right, shrink low
                low = mid + 1

        # Because the loop condition was low < high instead of low <= high, the loop can end
        # with low and high having converged onto a single index that was never checked
        # So we check that last remaining candidate here before giving up
        if reader.get(low) == target:
            return low

        # Target was not found anywhere in the array
        return -1