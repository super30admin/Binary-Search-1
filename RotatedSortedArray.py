from typing import List

# Time Complexity : O(logn) because we divide the array into halves after every iteration.
# Space Complexity : O(1) no extra space used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class RotatedSortedArray:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while (l <= r):
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if target > nums[mid] and target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

        return -1


rotatedSortedArr = RotatedSortedArray()
output = rotatedSortedArr.search([4, 5, 6, 7, 0, 1, 2], 0)
print(output)
