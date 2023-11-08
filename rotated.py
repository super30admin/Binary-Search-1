# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we compare if mid is greater than start - if yes its sorted and we search target in that. 
# else we see if second half is sorted if yes we search target there -
# else we search in the first half and try
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        n = len(nums)
        start=0
        end = n-1
        while(start<=end):
            mid = start + (end-start)/2
            if(nums[mid]==target):
                return mid
            elif(nums[mid]>=nums[start]):
                if(nums[start]<=target and target<=nums[mid]):
                    end=mid-1
                else:
                    start=mid+1
            else:
                if(nums[end]>=target and target>=nums[mid]):
                    start=mid+1
                else:
                    end=mid-1
        return -1