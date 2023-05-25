#Time Complexity=O(logn)
#Space Complexity =O(1)
#// Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n=len(nums)
        low,high=0,n-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid
            if nums[mid]>=nums[low]:
                if target>=nums[low] and target <=nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                if target>=nums[mid] and target <=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1