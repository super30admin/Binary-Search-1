#time complexity- o(log(n)) and space complexity - o(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        h=len(nums)-1

        while l<=h:
            m=(l+h)//2

            if target==nums[m]:
                return m
            if nums[l]<=nums[m]:
                if target>=nums[l] and target<nums[m]:
                    h=m-1
                else:
                    l=m+1
            else:
                if target>nums[m] and target<=nums[h]:
                    l=m+1
                else:
                    h=m-1
        return -1