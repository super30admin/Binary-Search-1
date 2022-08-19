class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i = 0
        j = len(nums)-1
        
        # find the pivot (smallest number)
        # k is the index
        while i <= j:
            k = (i+j)//2
            if nums[k] == target:
                return k
            elif nums[k] < nums[j]:
                j = k
            elif nums[k] > nums[j]:
                i = k
            else:
                j = k
        
        i = 0
        j = len(nums)-1
        
        if target <= nums[j] and target >= nums[k]:
            i = k
        else:
            j = k-1
            
        while i <= j:
            k = (i+j)//2
            if nums[k] == target:
                return k
            elif target >= nums[k]:
                i = k+1
            else:
                j = k-1
        
        return -1
