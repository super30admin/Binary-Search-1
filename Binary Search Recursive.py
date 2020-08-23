class Solution:
    
    def binarySearch(self, nums, low, high, target):
        if low > high:
            return -1
        mid = (low + high) // 2
        if nums[mid] == target:
            return mid
        if nums[low] <= nums[mid]:
            if nums[low] <= target and target < nums[mid]:
                high = mid - 1
                return self.binarySearch(nums, low, high, target)
            else:
                low = mid + 1
                return self.binarySearch(nums, low, high, target)
        if nums[mid] <= nums[high]:
            if nums[mid] < target and target <= nums[high]:
                low = mid + 1
                return self.binarySearch(nums, low, high, target)
            else:
                high = mid - 1
                return self.binarySearch(nums, low, high, target)
        
        
        
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        return self.binarySearch(nums, low, high, target)
