class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low,high=0,len(nums)-1
        while (low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                return mid
            elif nums[low]<=nums[mid]:
                if nums[mid]>target and nums[low]<=target:
                    high=mid-1
                else:
                    low=low+1
            else:
                if nums[high]>=target and nums[mid]<target:
                    low=mid+1
                else:
                    high=mid-1
        return -1