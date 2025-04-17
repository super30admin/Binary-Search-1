#TIme Complexityy :O(nlogn)
# Space COmplexity : O(1)
# Able to run on leetcode :Yes
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n= len(nums)
        l=0
        h=n-1
        while(l<=h):
            m = l+(h-l)//2
            if nums[m]== target:
                return m
            elif nums[l]<=nums[m]:
                if nums[l]<= target and nums[m]>=target:
                    h =m-1
                else:
                    l=m+1
            else:
                if nums[h]>= target and nums[m]<=target:
                    l=m+1
                else:
                    h =m-1
        return -1