class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums==None and len(nums)==0:
            return -1
        n=len(nums)
        l=0
        h=n-1
        while l<=h:
            mid=l+(h-l)//2
            if nums[mid]==target:
                return mid
            if nums[l]<=nums[mid]:
                if target<nums[mid] and target>=nums[l]:
                    h=mid-1
                else:
                    l=mid+1
            else:
                if target>nums[mid] and target<=nums[h]:
                    l=mid+1
                else:
                    h=mid-1
        return -1


        