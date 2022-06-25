# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Problems with the else part which is not sorted





class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        r=len(nums)-1
        
        while(l<=r):
            # To avoid integer overflow
            mid = l+(r-l)//2
            if nums[mid]== target:
                return mid
            #Check which part is sorted    
            elif(nums[l]<=nums[mid]):

                if target<nums[mid] and target >=nums[l]:
                    r = mid-1
                else:
                    l=mid+1
            else:
                if target>nums[mid] and target <=nums[r]:
                    l = mid+1
                else:
                    r=mid-1
        return -1