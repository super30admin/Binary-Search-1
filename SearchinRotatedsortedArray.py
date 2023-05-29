# Time Complexity : O(Logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


# Approach is to find the sorted side and then find the target, if the target is present in unsroted side then do the search corresponding .


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        n=len(nums)-1
        m=0
        
        if(nums[0] == target):
            return 0

        if(n==0):
            return -1
        while(l<=n):
            m=(l+n)//2
            print m
            if(nums[m] == target):
                return m
            if(nums[l]<=nums[m]):
                if( nums[l]<=target and nums[m]>=target ):
                    n=m-1
                else:
                    l=m+1
            else:
                if( nums[m]<=target and nums[n]>=target ):
                    l=m+1
                else:
                    n=m-1
        return -1 
            