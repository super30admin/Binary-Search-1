class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        if not nums:
            return -1
        
        low, high = 0 , len(nums)-1
        
        while low<=high:

            mid = (low+high)//2
            
            if nums[mid]==target:
                return mid
            
            elif nums[low]<=nums[mid]:
                
                if target>=nums[low] and target<nums[mid]:
                    high = mid -1
                
                else:
                    low = mid +1
            else:
                if target>nums[mid] and target<= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1
                    
                    
# time complexity is log n as we are applying binary search and reducing search space by two in every iteratiion

#Approach is to apply binary search in rotated array - at every iteration one half would atleast be sorted strictly,
# We use this fact to our advantage, if the sorted value lies in that half, we ignore the other half and vice versa.
            
        
        
#     to find which is sorted part

    
        
