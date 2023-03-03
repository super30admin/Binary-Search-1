#Getting error for [5,1,3] & target = 0 and [1,3] & target = 3 inputs.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        listLength = len(nums)
        low = 0
        high = listLength - 1
        
        if listLength == 0:
            return -1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if (nums[low] <= target) and (nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
    
            else:
                if (nums[mid] < target) and (nums[high] >= target):
                    low = mid - 1
                else:
                    high = mid + 1
                   
        return -1
                