# I applied binary search based on whether the list is left/right sorted until the search space is present 
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        r=len(nums)-1
        while l<=r:
            m=l+(r-l)//2
            if nums[m]==target:
                return m
            elif nums[l]<=nums[m]:
                # This is left sorted
                if nums[l]<=target<nums[m]:
                    r=m-1
                else:
                    l=m+1
            else:
                #This is right sorted
                if nums[m]<target<=nums[r]:
                    l=m+1
                else:
                    r=m-1
        return -1

        