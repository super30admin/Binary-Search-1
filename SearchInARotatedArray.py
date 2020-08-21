// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while low<=high:#using binary search
            print(low,high)
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]>=nums[low]:#finding which subarray is sorted and which is unsorted to narrow down the search
                if target<nums[mid] and target>=nums[low]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                if target>nums[mid] and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1