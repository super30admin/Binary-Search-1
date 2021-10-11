class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start=0
        end=len(nums)-1
        
        
        while(start<=end):
            mid=(start+end)//2
            
            if(nums[mid]==target):
                return mid
            
            
            elif(nums[start]<=nums[mid]): # This checks if the first part if sorted
                if(target>=nums[start] and target<nums[mid]):
                    end=mid-1
                else:
                    start=mid+1
            
            elif(nums[mid]<=nums[end]):
                if(target>nums[mid] and target<=nums[end]):
                    start=mid+1
                else:
                    end=mid-1
        return -1

# Time complexity: O(log n)
# Space complexity: O(1)