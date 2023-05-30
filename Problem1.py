class Solution(object):
    '''
    Time Complexity: O(log n)
    Space Complexity: O(1)
    '''

    def search(self, reader, target):
        low = 0
        high = 1

        # Find the range for the binary search
        while reader.get(high) < target:
            # Double the range until the target is within the range
            low = high
            high = 2 * high

        # Perform binary search within the range
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                # If the target is found, return its index
                return mid
            elif reader.get(mid) > target:
                # If the middle value is greater than the target,
                # reduce the range to the left half
                high = mid - 1
            else:
                # If the middle value is less than the target,
                # reduce the range to the right half
                low = mid + 1

        # If the target is not found, return -1
        return -1
