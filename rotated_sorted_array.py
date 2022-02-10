# // Time Complexity : # we will have O(mn) complexity
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Initially 

class Solution:
    def search(self, nums:List, target: int) -> int:
        s=0
        e=len(nums)-1
        #can be done using binary search
        while s<=e:
            
            mid=s+(e-s)//2
            
            if nums[mid]==target:
                return mid
            #check whethe array is left sored or right sorted
            #checming right sorted
            elif nums[mid]<=nums[e]:
                #now if tagerget is >than mid and target s< than end 
                if target >nums[mid] and target <=nums[e]:
                    
                    s=mid+1
                else:
                    e=mid-1
            else:
                #array sorted in left side
                
                if nums[mid]>target and target >=nums[s]:
                    e=mid-1
                else:
                    s=mid+1
        return -1
        
                    