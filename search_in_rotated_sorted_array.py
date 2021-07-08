# Time Complexity : O(log n) as this sort of like a modified binary search on an array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : yes, I actually followed this after the class, things were not clear for me on how to find the rotated index
# Any problem you faced while coding this : Initially my approach was to, first get the point where the array was rotated, once I have that index,
# then create a new array by joining the 2 halfs, do a binary search on this array and then return the index by doing a calculation
# but that turned out to be too long/complicated of an approach

# Your code here along with comments explaining your approach
#this approach is much simpler, since array is rotated at one point, if we consider mid, one half would be sorted and the other would not be
#depending on which half is sorted and where the target value lies, >l and <=mid or other part, we do standard binary search and return the index  
#also attaching my original code

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums)-1
        
        while(l<=r):
            mid = l+(r-l)//2
            
            if(nums[mid]==target):
                return mid
            
            #left is sorted
            if(nums[l]<=nums[mid]):
                if(nums[l]<=target and target<nums[mid]):
                    r = mid-1
                else:    
                    l = mid+1
            #right is sorted        
            else:
                if(nums[mid]<target and target<=nums[r]):
                    l = mid+1
                else:    
                    r = mid-1
        return -1
        
        
"""
class Solution:
    def find_rotation_index(self, arr, l, r):
        if(l<r):
            mid_point = (l+r)//2
            r_idx = None

            if(mid_point-1>=0 and arr[mid_point-1]<arr[mid_point]):        
                r_idx = self.find_rotation_index(arr, l, mid_point-1)
                if(r_idx):
                    return r_idx
            elif(mid_point-1>=0):
                return mid_point
            if(mid_point+1<=len(arr)-1 and arr[mid_point]<arr[mid_point+1]):
                r_idx = self.find_rotation_index(arr, mid_point+1, r)
                if(r_idx):
                    return r_idx
            elif(mid_point+1<=len(arr)-1):
                return mid_point+1
    
    def binarySearch(self, arr, l, r, x): 
        if(l<=r):
            mid_point = (l+r)//2

            if(l==r and arr[l]!=x):
                return -1
            if(arr[mid_point]==x):
                return mid_point
            elif(arr[mid_point]<x):
                return self.binarySearch(arr, mid_point+1, r, x)
            else:
                return self.binarySearch(arr, l, mid_point-1, x)
        
    def search(self, nums: List[int], target: int) -> int:
        r_idx = self.find_rotation_index(nums, 0, len(nums)-1)
        if(r_idx==None):
            r_idx = 0
            i = self.binarySearch(nums, 0, len(nums)-1, target)
        else:                
            new_array = nums[r_idx:] + nums[:r_idx]
            i = self.binarySearch(new_array, 0, len(new_array)-1, target)
        
        if(i==-1 or i==None):
            return -1
        else:
            recalculate_idx = i+ r_idx 
            if(recalculate_idx>=len(nums)):
                recalculate_idx -= len(nums)

            return recalculate_idx
"""
                