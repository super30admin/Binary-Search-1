class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        mid = (left + right) // 2
        
        while left <= right:
            if nums[mid] == target:
                return mid
            
            if nums[left] <= nums[mid]:
                if target >= nums[left] and target < nums[mid]:
                    right = right - 1
                else:
                    left = mid + 1
            else:
                if target >= nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            mid = (left + right) // 2
        return -1
