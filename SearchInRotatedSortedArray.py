from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        r=len(nums)-1
        while l<=r:
            mid=(l+r)//2
            if target==nums[mid]:
                return mid
            if nums[l]<=nums[mid]:
                if nums[mid]<target or target<nums[l]:
                    l=mid+1
                else:
                    r=mid-1
            else:
                if target<nums[mid] or target>nums[r]:
                    r=mid-1
                else:
                    l=mid+1
        return -1