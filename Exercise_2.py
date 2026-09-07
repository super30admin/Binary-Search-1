'''
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

Time Complexity :
O(log n)

Space Complexity :
O(1)

Did this code successfully run on Leetcode :
Yes

Conceptual Approach:

So here's the thing we know at any given point in time. At least one side of our array may be sorted, and the other side may be unsorted. We should
first:

- Find the sorted side
- Once we find the sorted side, check if our target is within that range. If it is, go to that side, otherwise go to the other

This logic still holds in a fully sorted array without any rotations

Edge Cases:

- Fully sorted array [1 2 3]
Need to make sure our binary search works on this kind of array as well! I.e. a normal sorted array

- 1 element array [3]
Make sure we aren't violating boundary conditions

- Element exists at boundaries of array (first / last index) [ 1 2 3 ] target = 1

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- 1 <= nums.length <= 5000

No empty array case

- -10^4 <= nums[i] <= 10^4

- All values of nums are unique.
No duplicate case so full binary search can work

- nums is an ascending array that is possibly rotated.

-10^4 <= target <= 10^4

Any problem you faced while coding this:

Yes, at first I thought. I could just do < instead of <=, but I realized how silly that was for _is_in_range, because if my value was contained
by the boundary, it would unintentionally return false.
'''
from typing import List


class Solution:
    def _is_in_range(self, nums: List[int], target: int, low: int, high: int) -> bool:
        return nums[low] <= target <= nums[high]

    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            # We always choose this way to avoid integer overflow even though mid = (low + high) // 2
            mid = low + (high - low) // 2
            left_is_sorted = nums[low] <= nums[mid]

            if nums[mid] == target:
                return mid
            elif left_is_sorted:
                if self._is_in_range(nums, target, low, mid):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if self._is_in_range(nums, target, mid, high):
                    low = mid + 1
                else:
                    high = mid - 1

        return -1