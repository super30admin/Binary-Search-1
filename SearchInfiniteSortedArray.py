# Time Complexity: O(log N), where N is the position of the target or the nearest upper bound.
# Space Complexity: O(1)

# Searches for a target value in a sorted array of unknown size using an ArrayReader.
# First expands the search range exponentially until the target is within range,
# then performs binary search within that range.


class ArrayReader:
    def get(self, index: int) -> int:
        # Returns the element at the specified index.
        # If index is out of bounds, returns a large value (e.g., 2**31 - 1).
        pass

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        # Expand the window exponentially until reader.get(high) >= target
        while reader.get(high) < target:
            low = high            # Move low to current high
            high *= 2            # Double the high bound

        # Perform binary search within the identified range
        return self.binary_search(reader, target, low, high)

    def binary_search(self, reader: 'ArrayReader', target: int, low: int, high: int) -> int:
        # Standard binary search using ArrayReader within the [low, high] range
        # Handles out-of-bounds access gracefully by relying on reader.get()

        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target:
                high = mid - 1   # Target is in the left half
            else:
                low = mid + 1    # Target is in the right half

        return -1