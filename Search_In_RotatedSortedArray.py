// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

Used binary search inorder to find the target value in array

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums)-1
        while(start<=end):
            mid = (start+end)//2
            if target == nums[mid]:
                return mid
            elif nums[start]<=nums[mid]:
                if target>=nums[start] and target<nums[mid]:
                    end = mid-1
                else:
                    start = mid+1
            else:
                if target<=nums[end] and target>nums[mid]:
                    start = mid+1
                else:
                    end = mid-1
        return -1


        
        