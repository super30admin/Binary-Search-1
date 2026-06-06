# SEARCH IN A ROTATED SORTED ARRAY
# TIME COMPLEXITY: O(log N) where N denotes the number of elements
# SPACE COMPLEXITY: O(1)
# Any problem you faced while coding this : ran into some edge cases error while doing the 
# submission but then was able to understand the flaw and implement the code
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start=0
        end=len(nums)-1
        while start<=end:
            mid=(start+end)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]>=nums[start]:
                if nums[start]<=target<=nums[mid]:
                    end=mid-1
                else:
                    start=mid+1
            else:
                if nums[mid]<=target<=nums[end]:
                    start=mid+1
                else:
                    end=mid-1
        return -1