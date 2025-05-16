# Time Complexity : O(log n) where n = length of nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums) - 1

        # binary search
        while low <= high:
            mid = (low + high) // 2

            # check mid
            if nums[mid] == target:
                return mid

            # decide which half is sorted
            if nums[low] <= nums[mid]:
                # left half is sorted
                if nums[low] <= target and target <= nums[mid]:
                    # target in left half
                    high = mid - 1
                else:
                    # target in right half
                    low = mid + 1
            else:
                # right half is sorted
                if nums[mid] <= target and target <= nums[high]:
                    # target in right half
                    low = mid + 1
                else:
                    # target in left half
                    high = mid - 1
                    
        # not found
        return -1
        

if __name__ == "__main__":

    sol = Solution()

    nums1 = [4, 5, 6, 7, 0, 1, 2]
    target1 = 0

    nums2 = [4, 5, 6, 7, 0, 1, 2]
    target2 = 3

    nums3 = [1]
    target3 = 0

    print(sol.search(nums1, target1))
    print(sol.search(nums2, target2))
    print(sol.search(nums3, target3))