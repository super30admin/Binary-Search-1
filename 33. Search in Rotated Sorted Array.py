# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0 or nums == None:
            return -1
        low = 0 
        high= len(nums)-1
        print(low,high)
        while (low<=high):
            mid = low + (high-low)//2
            if(nums[mid]==target):
                return mid
            elif (nums[low]<=nums[mid]):
                #left sorted
                if (target>=nums[low] and target<nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            else :
                #right sorted
                if (nums[mid]<target and nums[high]>=target):
                    low = mid+1
                else:
                    high = mid -1
        return -1