class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0: return -1
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2  # flooring mid value as list indices accepts int value
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:  # checking if left is sorted
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target:  # checking if right is sorted
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


obj = Solution()
obj.search(4,5,6,7,0,1,2,0)

