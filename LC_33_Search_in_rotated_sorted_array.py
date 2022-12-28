# TC = o(log(N)
# SC = O(1)

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums == [] or len(nums)== 0:
            return -1 

        low = 0
        high = len(nums) -1 

        #check for mid element
        while(low<=high):
            mid = int(low+(high-low)/2)

            if target == nums[mid]: #return the mid element: First step of Binary search
                return mid
        
        
            elif nums[low]<= nums[mid]: #check if left side is sorted:
                if nums[low]<= target and target <= nums[mid]: #check if target is in the left range
                    high = mid - 1
                else:
                    low = mid + 1

            

        #check if right side is sorted:
            else:#check if right side is sorted:
                if nums[mid] <= target and target<= nums[high]:
                    low = mid + 1
                else:
                    high = mid -1
            
        return -1 