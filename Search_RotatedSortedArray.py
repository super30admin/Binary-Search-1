# // Time Complexity : O(log N)
# // Space Complexity : O(log n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if(nums == None and len(num) == 0):
            return -1
        low = 0
        high = len(nums) -1
        
        while(low<=high):
            mid = int(low +(high-low)/2)
            
            if(nums[mid]==target):
                return mid
           
        #checking for left sorting 
            elif(nums[low]<=nums[mid]): #saying the left side is sorted
                if(nums[low]<= target and target<=nums[mid]):
                    high = mid-1
                else:
                    low = mid + 1
        #checking for right sorting if the left side is not sorted
            else:
                if(nums[mid]<= target and target <=nums[high]):
                    low = mid+1
                else:
                    high = mid - 1
        return -1
                
               
                
            
                
            
        