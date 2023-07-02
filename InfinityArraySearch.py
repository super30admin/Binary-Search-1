#TimeComplexity: O(log M + log N)
#SpaceComplexity:O(1)
class Solution:
    def search(self, reader: 'ArrayReader' , target : int) -> int:
        if reader.get(0) == target:
            return 0
        low = 0
        high = 1
        while reader.get(high) < target:  # Double the high index until a value greater than the target is found
            low = high
            high <<= 1

        # Perform binary search within the range [low, high]
        while low <= high:
            mid= low + (high-low)//2

            # If the middle element is the target, return its index
            if nums[mid] == target:
                return mid

            # If the middle element is less than the target, narrow the search to the right half
            elif nums[mid] < target:
                low = mid + 1
            
            # If the middle element is greater than the target, narrow the search to the left half
            else:
                high = mid - 1

        # If the target is not found in the array
        return -1

