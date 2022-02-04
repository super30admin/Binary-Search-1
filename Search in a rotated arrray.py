# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        s, e = 0, len(nums) - 1
        
        # to break out of loop
        while(s <= e):
            m = s + (e-s) // 2
            
            # if mid is the target
            if nums[m] == target:
                return m
            
            # to right sorted array
            elif nums[m] < nums[e]:
                
                # check whether target is on right range
                if nums[m]<target and target<nums[e]:
                    s = m + 1
                else:
                    e = m - 1
                    
            # unsorted array
            else:
                
                # check if target resides in it
                if nums[s]<target and target<nums[m]:
                    e = m - 1
                else:
                    s = m + 1
                    
        return -1
        