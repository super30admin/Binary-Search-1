# Time Complexity : O(Log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""

Brute force approach - Will take O(n) time
left = 0
right = 1
Loop through the entire array
    check if arr[left] > arr[right]
        return left
    else
        left += 1
        right +=1

"""

from typing import List


def search(self, nums: List[int], target: int) -> int:
    left = 0
    right = len(nums)

    while left <= right:
        middle = (left + right) // 2
        if nums[middle] == target:
            return middle
        elif nums[middle] > nums[left]:
            if nums[middle] >= target and nums[left] <= target:
                right = middle - 1
            else:
                left = middle + 1
        else:
            if nums[middle] >= target and nums[right] >= target:
                left = middle + 1
            else:
                right = middle - 1
    return -1
