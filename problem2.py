#search in a rotated sorted array
#SC:0(1)
#TC:O(logN)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums)==0:
            return -1
        left = 0
        right = len(nums)-1
        while left<=right:
            mid = left+(right-left)//2
            if nums[mid]==target:
                return mid
            
            if nums[mid]>=nums[left]:
                if nums[left]<=target <nums[mid]:
                    right = mid-1
                else:
                    left = mid+1
            else:
                if nums[mid]<target<=nums[right]:
                    left =mid+1
                else:
                    right = mid-1
        return -1