    # leet code passed

# 0(logN)
class Solution:  
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums)-1

        if len(nums) < 1 or nums == None:
            return -1
        while low <= high:
            mid = low + (high-low) // 2
            if target == nums[mid]:
                return mid
            if nums[low] <= nums[mid]:
                if target <= nums[mid] and target >= nums[low]:
                     high = mid-1
                else:
                    low = mid+1
            else: 
                if target >= nums[mid] and target < nums[high]:
                     low = mid+1
                else:
                    high = mid-1
                   
        return -1
                    