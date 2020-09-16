# Time Complexity: O(logn), where n is the length of array
# Space Complexity: O(1), since we are using only pointer l and r.

# This code was passsed on LC: Yes
# Problems: Forgot to take edge cases, but figured it out when solved it on whiteboard.

class Solution:
    def search(self, nums, target) -> int:
        
        l = 0 
        r = len(nums) - 1
        
        while l<=r:
            mid = (l+r)//2
            # return mid if we found the target
            if nums[mid]==target:
                return mid
            
            # Let's search the array in two halves
            # 1. hoping that we get target in nums[l] and nums[mid]
            # 2. hoping we get target in nums[mid] and nums[r]
            if nums[l]<=nums[mid]:
                # check which part we are having target and move pointers accordingly
                if nums[l]<=target<=nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            elif nums[mid]<=nums[r]:
                if nums[mid]<=target<=nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1