# Time complexity is O(log n) and space complexity is O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
#Initializing start and end indices      
        s=0
        e=len(nums)-1
# Checking whether all elements are sorted and finding the mid      
        while s<=e:
            m = s+(e-s)//2
# Returning index of element if found            
            if nums[m] == target:
                return m
# Searching in the left part
            if nums[s]<=nums[m]:
                if nums[s]<=target and target<nums[m]:
                    e = m-1
                else:
                    s=m+1
                    
# Searching in the right part                    
            else:
                if nums[m]<target and target <= nums[e]:
                    s=m+1
                else:
                    e =m-1
                    
        return -1
                    
