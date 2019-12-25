// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution(object):
    def search(self, nums, target):
        l=0
        r=len(nums)-1
        while(l<=r):
            mid=(l+r)//2
            if(target==nums[mid]):
                return mid
            elif (nums[l]<=target and target<nums[mid]):
                r=mid-1
            elif (target<=nums[r] and target>nums[mid]):
                l=mid+1
            elif (nums[mid]>nums[r]):
                l=mid+1
            else:
                r=mid-1
        return -1
