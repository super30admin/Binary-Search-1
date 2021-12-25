# Search in roatated array
# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Missed the class but watched the video to understand solution
# // Your code here along with comments explaining your approach

class Solution:
    def search(self, nums, target): 
        low, high = 0, len(nums)-1
        while(low<=high):
            mid = low+(high-low)//2
            if(nums[mid] == target): return mid
            elif (nums[low] <= nums[mid]):#left is sorted
                if(nums[low] <= target and nums[mid] > target):#num is in left side of the array
                    high = mid -1
                else:
                    low = mid+1
            else:#right part or array is sorted 
                if(nums[mid] < target and nums[high] >= target):#ele is in right side 
                    low = mid+1
                else:
                    high = mid -1
        return -1
                    
                    
                    
            
            
        