class Solution:
    def search(self, nums: List[int], target: int) -> int:

        #we will use binary search to solve this.
        start =0 ;end=len(nums)-1
        while start<=end:
            mid = (start+end)//2

            if target==nums[mid]:
                return mid

            if nums[start]<=nums[mid]: #check if left side is sorted in ascending order
                if target <nums[mid] and target>=nums[start]:
                    end=mid-1
                else:
                    start=mid+1
            else: #if right side is sorted
                if target>nums[mid] and target<=nums[end]:
                    start=mid+1
                else:
                    end=mid-1

        return -1
