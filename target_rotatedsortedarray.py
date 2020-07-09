class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start=0
        end=len(nums)-1
        while(start<=end):
            mid=start+(end-start)//2
            if nums[mid]==target:
                return mid
            if nums[start]<=nums[mid]:
                if target<nums[mid] and target>=nums[start]:
                    end=mid-1
                else:
                    start=mid+1
            else:
                if target>nums[mid] and target<=nums[end]:
                    start=mid+1
                else:
                    end=mid-1
        return -1