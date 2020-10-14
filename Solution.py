// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # if list is empty return -1
        if not nums:
            return -1


        low, high=0, len(nums)-1
        
        while low<=high:
            #find Mid 
            mid=low+(high-low)//2
            #if target is in the mid element return mid 
            if target == nums[mid]:
                return mid
            # if left side is sorted check if target lies in left side
            if nums[low]<=nums[mid]:
                if nums[low]<=target and target<nums[mid]:
                    high=mid-1
                else:
                low=mid+1
            #if right side is sorted check if target lies in right side
            else:
                if nums[mid]<target and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
            
        return -1
                
        
