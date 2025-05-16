# // Time Complexity : binary searh o(logn)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#  took some time to understand the intutiton but was able to understand  after the lecture. faced issues with how to approach initially and how to implement even after having idea


# // Your code here along with comments explaining your approach in three sentences only
# 1) idea is to divide half or ignore one part of the array everytime (basis of bs) and divide in half to get 0(logn)
# 2) for every sorted rotated array there will always be atleast one half that is sorted
# 3) use the principle 2 to either ignore or choose to search in the sorted half by a) deciding which half is sorted (compare mid with either first of last) 
#  b) if target lies there or not 

from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,h=0,len(nums)-1
        while l<=h:
            mid = l + (h-l//2)
            if target == nums[mid]:
                return mid
            elif nums[mid] > nums[l]:
                # left part sorted decide if target is in range
                if target >= nums[l] and target < nums[mid]:
                    h = mid -1
                else:
                    l = mid +1
            else:
                if target > nums[mid] and target <= nums[h]:
                    l = mid +1
                else:
                    h = mid -1
        return -1
            





        


