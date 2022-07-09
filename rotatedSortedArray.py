"""
https://leetcode.com/problems/search-in-rotated-sorted-array/

Single pass modified binary search

Method 1: Linear Search --> O(n)
Method 2: In sorted rotated arrays, One of the array halves or sub-array will always be sorted surely. Or both of the
sub-arrays will be sorted. Half is wrt to the mid value.
1. Find mid
2. Find the sorted sub-array
3. Check if target is lying in sorted sub-array. Reduce the sub-space to include this part. Repeat steps 1-3
Method 3: Find pivot using binary search. Using pivot, apply binary search to get target. 2-pass binary. Not scalable.

# Edge case:
1. Both arrays are sorted.


Runtime Complexity: log(n)
Space Complexity: O(1)

Yes it worked on Leetcode
No problems.
"""

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid
            # check for sorted sub-array
            elif nums[low] <= nums[mid]:  # left sorted array;
                # check if number lies in this sub-array
                if nums[low] <= target and nums[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[mid] <= target and nums[high] >= target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
