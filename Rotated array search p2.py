# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Understanding all the possible 4 cases


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        
        l = 0
        h = len(nums) - 1
        
        while(l<=h):
            mid = (l+h)//2
            
            if target == nums[mid]:
                return mid
            
            # Check which side of the array the mid belongs to:
            
            # Left Side
            if nums[l] <= nums[mid]:
                #Check which side of the array to look in as there can be two possiblites
                # 1. from l to mid (sorted) if target > nums[mid] or target < nums[l]
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                
                else:
                    h = mid - 1
                    
            # Right Side
            else:
                 #Check which side of the array to look in as there can be two possiblites
                # 1. from l to mid (sorted) target < nums[mid] or target > nums[h]
                if target < nums[mid] or target > nums[h]:
                    h = mid - 1
                # 2. If 1 is false then it is the other side of the array
                else:
                    l = mid + 1
        return -1
    
o = Solution()
print(o.search([4,5,6,0,1,2,3], 5))