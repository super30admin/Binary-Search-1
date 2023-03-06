
from typing import List


class Solution:
    def search_infinite_array(self, arr: List[int], target: int) -> int:
        """
        Search for target in infinite sorted array using binary search.
        """
        # Determine the search range.
        low, high = 0, 1
        while target > arr[high]:
            low = high
            high *= 2
        
        # Perform binary search in the search range.
        while low <= high:
            mid = low + (high - low)/ 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
