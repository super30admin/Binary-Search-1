from typing import List
#Did this code successfully run on Leetcode :O(log(n))
#Any problem you faced while coding this : Not any problem anything specific
#Here all the methods have the space complexity of O(1)
class Solution:
    '''Time Complexity is O(log(n)), Where n is the size of the array'''
    #The following function is just an binary search
    def binarysearch(self,nums: List[int], target,l,r):
        while(l<=r):
            mid=(l+r)//2
            if(nums[mid]==target):
                return mid
            if(nums[mid]>target):
                #check in the left side
                l,r=l,mid-1
            if(nums[mid]<target):
                l,r=mid+1,r
        return -1
    '''Time Complexity is O(log(n)), Where n is the size of the array'''        
    def search(self, nums: List[int], target: int) -> int:
               
        l=0
        r=len(nums)-1
        
        while(l<=r):
            #print(f"Beginning :{l},{r}")
            if(l==r):
                if(nums[l]==target):
                    return l
                else:
                    return -1
            
            mid=(l+r)//2 #lower median
            
            if(nums[mid]==target):
                return mid
            else:
                if(nums[mid]>=nums[l]):#Here this equal to condition will cover an edge case
                    #Here we can say that left side of the mid is in sorted order
                    if(target<nums[mid] and target>=nums[l]):
                        #do binary search in the left side
                        return self.binarysearch(nums,target,l,mid-1)
                    else:
                        #do search on the right side
                        l,r=mid+1,r
                        #print(f"End :{l},{r}")
                        continue 
                     
                if(nums[mid]<nums[l]):
                    #Here we can say that right side of the mid is in sorted order
                    if(target>nums[mid] and target<=nums[r]):
                        #do binary search in the right side
                        return self.binarysearch(nums,target,mid+1,r)
                    else:
                        #do search in the left side
                        l,r=l,mid-1
                        #print(f"End :{l},{r}")
                        continue
                        
            
            
        return -1    
            