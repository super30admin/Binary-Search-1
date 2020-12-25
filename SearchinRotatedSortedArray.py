#Time complexity = O(logn) 
#space complexity= O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : yes while trying to find a O(logn) solution, finally learnt the logn solution from sir.



class Solution:
  
    def search(self, nums: List[int], target: int) -> int:

            
        def binarysearch(nums,l,r):
            while(l<=r): #traversing through the array 
                m=(l+r)//2 #searching for the middle element
                n=nums[m]
                if(n==target): 
                    return m
                elif(n>target):
                    r=m-1
                else:
                    l=m+1
            return -1
                
        l=0
        r=len(nums)-1
        
        while(l<=r):
            mid=(l+r)//2
            if(target==nums[mid]):
                return mid
            if(nums[l]<=nums[mid]):
                if(target<= nums[mid] and target>=nums[l]):
                    return binarysearch(nums,l,mid)
                else:
                    l=mid+1
            
            elif(nums[mid]<=nums[r]):
                if(target<= nums[r] and target>=nums[mid]):
                    return binarysearch(nums,mid,r)
                else:
                    r=mid-1
                
                
                   
        return -1
        


                