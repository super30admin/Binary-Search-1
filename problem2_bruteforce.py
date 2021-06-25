#brute force approch 
#time Comp- O(n) size of nums
#space comp- O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        for i in range(0,len(nums)):
            if nums[i]==target:
                return i
        return -1
        
