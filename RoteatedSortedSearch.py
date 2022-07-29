class Solution:
    def search(self, nums: List[int], target: int) -> int:#time O(logn) space O(1)
        lo=0 ; hi=len(nums)-1
        while lo<=hi:
            mid=(lo+hi)//2
            if target==nums[mid]: return mid
            elif nums[lo]<=nums[mid]:
                if nums[lo]<=target and nums[mid]>=target:
                    hi=mid-1
                else:
                    lo=mid+1
            else:
                if nums[mid]<=target and nums[hi]>=target:
                    lo=mid+1
                else:
                    hi=mid-1
        return -1
