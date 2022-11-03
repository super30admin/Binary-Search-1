#Time Complexity: O(logn)
#Space Complexity: O(1)
#Successfully ran on leetcode
class Solution:
    def search(self, nums: list(int), target: int) -> int:
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid]==target:
                return mid
            #If left part is sorted
            elif nums[low]<=nums[mid]:
                if target>=nums[low] and target<nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            #if right part is sorted
            else:
                if target>nums[mid] and target<=nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1