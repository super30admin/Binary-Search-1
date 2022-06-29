'''

## Problem 33: Search in Rotated Sorted Array

## Author: Neha Doiphode
## Date:   06-25-2022

## Description:
    There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
    such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target,
    return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

## Examples
    Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4

    Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1

    Example 3:
        Input: nums = [1], target = 0
        Output: -1

    Example 4:
        Input: nums = [5, 1, 3], target = 0
        Output: -1

## Constraints:
    * 1 <= nums.length <= 5000
    * -104 <= nums[i] <= 104
    * All values of nums are unique.
    * nums is an ascending array that is possibly rotated.
    * -104 <= target <= 104

## Time complexity : O(log n), since we are using binary search.

## Space complexity: O(1), No auxiliary space is used.
'''
from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        answer = -1
        if low == high:
            answer = low if target == nums[low] else -1
            return answer

        while low <= high:
            # Calculate mid
            mid = low + (high - low) // 2

            # check if element is present at mid position
            if nums[mid] == target:
                return mid

            # Check if left part if sorted
            elif nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            # Check if right part is sorted
            elif nums[mid] <= nums[high]:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return answer


# Driver code
solution = Solution()
nums = [4, 5, 6, 7, 0, 1, 2]
print(f'Original array: {nums}')
print(f'Enter the key to search: ', end = '')
target = int(input())
#import pdb;pdb.set_trace()
answer = solution.search_1(nums, target)
print(f"Key Index: {answer} (-1 should be interpreted as key not present.)")
