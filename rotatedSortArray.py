# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        if not nums or len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1
        
        while (low <= high):
            mid = low+(high-low)//2
            
            #I got the target
            if target == nums[mid]:
                return mid
            # if we don't get the target at mid: here when we closely look at the array we see one part of the array is always sorted compared other; either left is sorted compare to right or either way

            #checking if left is sorted
            if nums[low] <= nums[mid]:
                #checking if the element lies in left sorted array
                if target >= nums[low] and target < nums[mid]:
                    # if yes, go left
                    high = mid-1
                else:
                    #or go right if not
                    low = mid+1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid+1
                else:
                    high = mid-1
                    
        return -1


        