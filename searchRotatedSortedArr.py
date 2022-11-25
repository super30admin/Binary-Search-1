#Time Complexity :  log(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0                                                   #left pointer is set to 0th index
        r = len(nums)-1                                         #right pointer is set to last index
        
        while l <= r:
            m = l + (r-l)//2                                    #computing the mid and check overflow
            
            if nums[m] == target:                               #we see if elem at mid is the target
                return m
            
            if nums[l] <= nums[m]:                              #checking if left half of array is sorted
                if target < nums[m] and target >= nums[l]:      #if yes we check if target is within left half portion
                    r = m - 1                                   #by decrementing right = mid - 1
                else:
                    l = m + 1                                   #otherwise we check the right half by changing left = mid + 1
            
            else:                                               #checking right half
                if target > nums[m] and target <= nums[r]:      #if target is in right half portion
                    l = m + 1                                   #we change left = mid + 1
                else:
                    r = m - 1                                   #otherwise we look on left half by changing right = mid - 1
        return -1