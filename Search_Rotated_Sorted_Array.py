# Time Complexity : o(log n)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, h = 0, len(nums)-1
        
        while l<=h:
            m = (l+h)//2
            if nums[m] == target:
                return m
            else:
                if nums[l]<=nums[m]:   # reflects that the subarray is sorted
                    if target>=nums[l] and target< nums[m]:
                        h = m-1
                    else:
                        l = m+1
                else:                  # unsorted
                    if  target> nums[m] and target<=nums[h]:  
                        l = m+1
                    else:
                        h = m-1
        return -1             
        