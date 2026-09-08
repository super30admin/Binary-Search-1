"""
Brute Force: Linear Search

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 33. Search in Rotated Sorted Array) : Yes
Any problem you faced while coding this : None

Approach:
We simply scan through the array from left to right checking each element against the target.
This ignores the fact that the array is rotated/sorted since it checks every index regardless of order.
It works correctly but does not take advantage of the O(log n) potential of a sorted/rotated array.
"""
from typing import List
class SolutionLinear:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0 or target is None:
            return -1
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        return -1


def run_tests_linear():
    assert SolutionLinear().search([4,5,6,7,0,1,2], 0) == 4
    assert SolutionLinear().search([4,5,6,7,0,1,2], 3) == -1
    assert SolutionLinear().search([1], 0) == -1
    assert SolutionLinear().search([], 5) == -1
    assert SolutionLinear().search([1], 1) == 0
    print("All Linear Search test cases passed!")


"""
Optimized Solution: Binary Search

Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 33. Search in Rotated Sorted Array) : Yes
Any problem you faced while coding this : None

Approach:
We use modified binary search, checking at each step whether the left half or right half of the current range is properly sorted.
Once we know which half is sorted, we check if the target lies within that sorted half's value range to decide which direction to move.
This lets us discard half the search space each iteration even though the array as a whole is rotated.
"""
class SolutionBinary:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0 or target is None:
            return -1
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:  # left half is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:  # right half is sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1


def run_tests_binary():
    assert SolutionBinary().search([4,5,6,7,0,1,2], 0) == 4
    assert SolutionBinary().search([4,5,6,7,0,1,2], 3) == -1
    assert SolutionBinary().search([1], 0) == -1
    assert SolutionBinary().search([], 5) == -1
    assert SolutionBinary().search([1], 1) == 0
    assert SolutionBinary().search([5,1,3], 5) == 0
    print("All Binary Search test cases passed!")


if __name__ == "__main__":
    run_tests_linear()
    run_tests_binary()