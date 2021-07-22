# // Time Complexity : O(log N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : N/A
# Leetcode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/


# // Your code here along with comments explaining your approach
def search(self, nums: List[int], target: int) -> int:
    l, r = 0, len(nums)-1
    while l <= r:
        mid = (l+r)//2
        print(nums[mid])
        if nums[mid] == target:
            return mid
        
        # Unrotated array or subarray
        elif nums[mid] >= nums[l]:
            
            # If the target is within this subarray
            if nums[l] <= target < nums[mid]:
                r = mid-1
                
            # If not, it's in the right
            else:
                l = mid+1
            
                
        # Rotated array or subarray
        else:
            
            # If the right subarray is nonrotated and target is within it
            if nums[mid] < target <= nums[r]:
                l = mid+1 
                
            # If not, it's in the left
            else:
                r = mid-1
    return -1