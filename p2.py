class Solution:
    def search(self, nums: List[int], target: int) -> int:
        #array only has 1 element
        if len(nums) == 1 and nums[0] != target:
            return -1
        
        #array is rotated back to its original

        l = 0
        h = len(nums) - 1
        # [4,5,6,7,0,1,2]; h = 6
        
        while l <= h:
            mid = l + (h - l) // 2

            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]: #check if its left sorted 
                #if its sorted, then check if target falls in the range
                if nums[l] <= target < nums[mid]:
                    h = mid - 1 #target in the range, perform binary search on left 
                else:
                    l = mid + 1
            else: #right sorted
                if nums[mid] < target <= nums[h]:
                    l = mid + 1
                else: 
                    h = mid - 1

        return -1
                

                

            
                