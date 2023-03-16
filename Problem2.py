class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        r= len(nums)-1
        
        while l<=r:
            mid= (l+r)//2
            if target== nums[mid]:
                return mid
            
            # Checking if LSA is sorted.
            if nums[l]<= nums[mid]:
                if target >=nums[l] and target< nums[mid]:
                    r= mid-1 # Target is in the left sorted portion
                else:
                    l= mid+1 # Target is on the right side.
            else:
                if target <=nums[r] and target >nums[mid]:
                    l= mid +1
                else:
                    r= mid -1
        return -1
