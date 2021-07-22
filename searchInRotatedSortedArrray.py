//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : NO





class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) -1 
        while(low<=high):
            mid= (low + high ) //2
            if(nums[mid]==target):
                return mid
            elif(nums[low]<=nums[mid]):
                if(target<nums[mid] and target >=nums[low]):
                    high=mid-1
                else:
                    low=mid+1
            else:
                if(target>nums[mid] and target <=nums[high]):
                    low=mid+1
                else:
                    high=mid-1
        return -1
        