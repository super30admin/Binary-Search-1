#// Time Complexity : O(logn) as it is using binary search.
#// Space Complexity : O(1) constant time as it is not using any auxilary memory.
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : No


#// Your code here along with comments explaining your approach
#//since it is rotated binary array while performing binary search we end up mostly with one sorted and one unsorted arrays.we then check #//whether the element is present in the sorted or unsorted side.If the element is present on any of the either sides we return the index #//of that element else we return -1 indicating that the element is not present.



class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low=0
        high=len(nums)-1
        if len(nums)==0:
            return -1
        while (low<=high):
        //finding the middle index
            mid=int(low+(high-low)/2)
            if nums[mid]==target:
                return mid
        // we are checking the sorted part of the array
            elif nums[mid]>=nums[low]:
                if nums[low]<=target<=nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
        //This is for the unsorted part of the array.
            else:
                if nums[mid]<=target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1
                    
        