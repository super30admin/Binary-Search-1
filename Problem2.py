class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left+(right-left)//2
            if nums[mid] == target:
                return mid
            
            if nums[mid] >= nums[left]:
                # left is sorted, or both are sorted
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1

            else:
                # right is sorted
                if target > nums[mid] and target <= nums[right]:
                    left = mid  + 1
                else:
                    right = mid -1

        return -1