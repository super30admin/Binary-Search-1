class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #implementing modified BS by first checking which part is sorted and then continue with BS
        #O(logN)
        #O(1)
        
        #base condition
        if not nums:
            return -1
        
        l=0
        h=len(nums)-1
        
        while l<=h:
            m=l+((h-l)//2)
            #found element at mid
            if nums[m]==target:
                return m
            #check if left side is sorted
            elif nums[m]>=nums[l]:
                #check if target is within that part range
                if target >=nums[l] and target<nums[m]:
                    h=m-1
                else:
                    l=m+1
            else:#right side is sorted
                #check if target is within that part range
                if target >nums[m] and target<=nums[h]:
                    l=m+1
                else:
                    h=m-1
        #not found
        return -1
                
            
                    