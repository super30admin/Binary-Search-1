// Time Complexity : average case - O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: used 2 pointer approach from front and last'


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i = 0
        j = len(nums)-1
        if j == 0 and target in nums:
            return 0
        while i<=j:
            if nums[i] == target:
                return i
            if nums[j] == target:
                return j 
            i += 1
            j -= 1
        return -1 
