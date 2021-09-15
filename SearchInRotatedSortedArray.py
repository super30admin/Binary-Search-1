# Time complexity: O(log n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : had trouble figuring out the logic to identify the sorted half to search

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums)-1

        while left <= right:
            mid = (left+right)//2

            if nums[mid] == target:
                return mid
            # if left half is the lower half of the sorted array
            if nums[left] <= nums[mid]:
                # if the target value lies between the low and mid point, the search area is between low and mid, so move right. Otherwise move left
                if nums[left] <= target <= nums[mid]:
                    right = mid-1
                else:
                    left = mid+1
            else:
                # if target value lies between the mid and right, that's the search area, so move left otherwise, move right
                if nums[mid] <= target <= nums[right]:
                    left = mid+1
                else:
                    right = mid-1
        return -1


solution = Solution()
print(solution.search([4, 5, 6, 7, 0, 1, 2], 0))
print(solution.search([7, 0, 1, 2, 4, 5, 6], 0))
print(solution.search([2, 4, 5, 6, 7, 0, 1], 0))
print(solution.search([5, 6, 7, 0, 1, 2, 4], 0))
