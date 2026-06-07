# Search in Rotated Sorted Array

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1

        while low<=high:
            mid = (low+high) // 2

            if nums[mid] == target:
                return mid
            
            # Check for left sorted array or not:
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] >= target:
                    # target must be here
                    high = mid-1
                else:
                    low = mid+1
            
            else: 
                # At this point, it's right sorted
                if nums[mid] <= target and nums[high]>=target:
                    low = mid+1
                else:
                    high = mid-1
            
        return -1