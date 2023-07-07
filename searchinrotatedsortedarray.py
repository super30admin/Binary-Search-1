#time complexity: O(logn)
#space complexity: O(1)

class Solution:
    def search(self, nums, target):
        self.nums=nums
        self.target=target
        self.low=0
        self.high=len(nums)-1
        
        while(self.low<=self.high):
            mid=self.low+(self.high-self.low)//2
            
            if(nums[mid]==target):
                return mid
            if(nums[self.low]<=nums[mid]):
                if(target>=nums[self.low] and target<nums[mid]):
                    self.high=mid-1
                else:
                    self.low=mid+1
            else:
                if(target>nums[mid] and target<=nums[self.high]):
                    self.low=mid+1
                else:
                    self.high=mid-1
                    
        return -1
                
                
                
                    
        