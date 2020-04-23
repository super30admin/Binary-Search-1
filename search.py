
# // Time Complexity :O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :

#Declare   variables for left most index and rightmost index of the array.
# To cover all test cases , an array with only one element also, check if left<=right
# While left is lesser or equal to right , assign value for mid index, and check if the target given is exactly mid, if so return mid index.
# If it is not equal to mid index, then check if lies between left index and mid index, and update the values of the indicies respectively.
# Do the similar calculation if we find that the the target lies between mid and right most index.
#Here we keep on updating the left and right indices as we find out taht target lies between certain two numbers in array.




class Solution:
    def search(self, nums: List[int], target: int) -> int:
        r=len(nums)-1
        l=0
        if not nums:
            return -1
        
        while l<=r:
            mid=l+(r-l)//2
            if nums[mid]==target:
                return mid
            if nums[l]<=nums[mid]:
                if nums[l]<=target<=nums[mid]:
                    r=mid-1
                else:
                    l=mid+1
            elif nums[r]>=nums[mid]:
                if nums[r]>=target>=nums[mid]:
                    l=mid+1
                else:
                    r=mid-1
                    
        return -1
                
            
        
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
# # Test array
# arr = [ 2, 3, 4, 10, 40 ]
# x = 10
  
# # Function call
# result = binarySearch(arr, 0, len(arr)-1, x)
