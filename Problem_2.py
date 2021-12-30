#LC 33 - Search in a Sorted Array
#Time Complexity : O(log N)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low+(high-low)//2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                if nums[high] >= target and nums[high] < nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
            else:
                if nums[low] <= target and nums[low] > nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
        return -1

