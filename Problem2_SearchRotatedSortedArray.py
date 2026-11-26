# Time Complexity : O(log n) - each step discards the half that cannot contain the target
# Space Complexity : O(1) - only low, high, mid are used

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        if nums is None or target is None or len(nums)==0:
            return -1
        low =0
        high = len(nums)-1
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                return mid
            #left sorted 
            if nums[low] <=nums[mid]:
                if nums[low]<=target <nums[mid]:
                    high = mid-1
                else:
                    low =mid+1
            else:
                # right sorted 
                if nums[mid]<target<=nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1