"""Given that in any rotated sorted array, it is garaunteed that atleast one side of the mid is sorted.
After getting mid element, we can compare if the target lies in the subarray which is sorted, if not it
for sure lies in the other subarray. Thus keep choosing subarrays iteratively until we find our target.
Time complexity will be O(logn)
Space complexity will be O(1)"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high  = 0, len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2

            if nums[mid] == target: return mid

            if nums[low] <= nums[mid]:
                if nums[low]<=target and target<nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
            elif nums[mid] <= nums[high]:
                if target>nums[mid] and target<=nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1