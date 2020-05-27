# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
'''
I have used a modified version of Binary search to find the pivot index. Here pivot index would be i such that A[i] > A[i+1]

Then I divided the given array from the pivot index into 2 parts and used coneventional binary search 
'''

class Solution:
    
    def get_pivot(self, nums, start, end):
        
        while start < end:
            mid = int((start + end)//2)
            
            if mid < end and nums[mid] > nums[mid+1]:
                
                return mid

            elif mid >=1 and nums[mid-1] > nums[mid]:
                return mid-1

            elif nums[start] >= nums[mid]:
                return self.get_pivot(nums, start,mid-1)
            
            else:
                return self.get_pivot(nums, mid+1, end)
                            
    
    def binary_search(self, nums, start, end, target):
        
        while (start <= end):
        
            mid = int((start + end)//2)
            
            print ("mid",mid)
            if nums[mid] == target:                
                return mid

            elif target < nums[mid]:
                return self.binary_search(nums, start, mid-1,target)

            else:
                return self.binary_search(nums, mid+1, end, target)
        else:
            
            return -1
                
    
    def search(self, nums, target):
        
        if nums != []:
            pivot = self.get_pivot(nums,0,len(nums)-1)
            
            if pivot is not None and pivot >=0:
                if nums[pivot] == target:
                    return pivot
                
                L = self.binary_search(nums, 0, pivot-1, target)
                if L == -1:
                    return self.binary_search(nums,pivot+1,len(nums)-1,target)
                
                return L
            else:
                return self.binary_search(nums, 0, len(nums)-1, target)
        
        return -1
        
        
        