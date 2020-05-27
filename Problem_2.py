"""

    Student : Shahreen Shahjahan Psyche

    Time Complexity : O(2 log N)
    
    Space Complexity : O(1)

    The code ran successfully. 

"""

from typing import List

class Solution:

    # A normal binary search function.
    def _binary_search(self, start: int, end: int, nums: List[int], target: int) -> int:

        while (start <= end):
            mid = (start + end) // 2

            if target == nums[mid]:
                return mid

            if target < nums[mid]:
                end = mid - 1
            else:
                start = mid + 1

        return -1

    # First, we figure out the starting index and the ending index of the array which might consist the target. Then, passing those starting and ending index to the 
    # binary search function 

    def search(self, nums: List[int], target: int) -> int:

        # First we need to find the start and end index from this infinite sorted array for the target.

        start = 0
        end = 1
        val = nums[0]

        while (val <= target):
            start = end
            end = 2 * end
            val = nums[end]

        index = self._binary_search(start, end, nums, target)

        return index


# Testing the code
my_array = [i for i in range(100, 10000001)]
binary_search_object = Solution()
print(binary_search_object.search(my_array, 512))