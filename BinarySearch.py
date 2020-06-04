# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    
    #Iterative
    # Time Complexity : O(n)
    # Space Complexity : O(1)
    # def search(self, nums, target):
    #     if not nums:
    #         return -1 
    #     i = 0 
    #     j = len(nums) - 1 
    #     while i <= j:
    #         mid = (i+j) //2 
    #         if nums[mid] == target:
    #             return mid 
            
    #         if nums[i] <= nums[mid]:
    #             if nums[i] <= target <= nums[mid]:
    #                 j = mid -1 
    #             else:
    #                 i = mid + 1 
    #         else:
    #             if nums[mid] <= target <= nums[j]:
    #                 i = mid + 1 
    #             else:
    #                 j = mid - 1 
    #     return -1 
    
    #recursive 
    # Time Complexity : O(n)
    # Space Complexity : O(n)
    def search(self,nums,target):
        if not nums or len(nums) == 0:
            return -1 
        def helper(nums,target,low,high):
            if low > high:
                return -1 
            
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid 
            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    return helper(nums,target,low,mid-1)
                else:
                    return helper(nums,target,mid+1,high)
            else:
                if nums[mid] <= target <= nums[high]:
                    return helper(nums,target,mid+1,high)
                else:
                    return helper(nums,target,low,mid-1)
        
        return helper(nums,target,0,len(nums)-1)
        
if __name__ == "__main__":
    bs = Solution()
    nums = [4,5,6,7,0,1,2]
    print(bs.search(nums,8))
