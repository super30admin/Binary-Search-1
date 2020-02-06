// Time Complexity : O(log n) with base 2 is the time complexity. If target is the middle value (best-case scenario), it is O(1).
// Space Complexity : O(1) constant space complexity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I kept getting error with an index value of -1 until i used continue to return back 
to the begining of while loop. 


// Your code here along with comments explaining your approach: Initially, we calculated the  length and defined the left and right 
index parameters as 0 and n-1, before calculating the middle value while left index is lesser than right index. If middle is equal to 
target, it is returned as the resultant index, else we shift the index one step to right or left and ascertain if target lies on 
any of the 2 sides. Once target is found, we re-adjust left or right value and narrow dowwn the search area, so as to recalculate the 
middle value unitl we have found the target value.

class Solution(object):

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        // Sanity checks
        if len(nums) == 0 or not nums:
            return -1
        
        n = len(nums)
        left, right = 0, n-1
        while left <= right:
            
            // Find the middle index and check if it is the target
            middle = left + ((right-left)//2)           # Formula to counter integer overflow problem
            if nums[middle] == target: 
                return middle
            
            // right-sorted?
            if nums[middle + 1] <= nums[right]: 
                if nums[middle + 1] <= target <= nums[right]:
                    left = middle + 1
                    continue
                else: 
                    right = middle - 1
                    continue                    
            
            //left-sorted?
            if nums[left] <= nums[middle - 1]:
                if nums[left] <= target <= nums[middle - 1]:
                    right = middle - 1
                    continue
                else: 
                    left = middle + 1
                    continue
            
            else: break
        
        return -1
