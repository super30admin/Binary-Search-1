# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            # check if the array is left sorted
            elif nums[low]<=nums[mid]:
                if nums[low]<=target and nums[mid]>target:
                    high = mid-1       # If target is present in left subarray 
                else:
                    low = mid+1         #else right subarray
            #Right sorted array
            else:
                if nums[mid]<target and nums[high]>=target:
                    low = mid+1
                else:
                    high = mid-1
        return -1
