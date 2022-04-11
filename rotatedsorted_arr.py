class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums)-1
        
        while start<=end:
            mid = (start+end)//2
            
            if nums[mid] == target:
                return mid
            
            if nums[start] <= nums[mid]:
                if nums[start] <= target < nums[mid]:  # search left half
                    end = mid-1
                else:
                    start = mid+1
                    
            elif nums[end] >= nums[mid]:
                if nums[end] >= target > nums[mid] :  # search right half
                    start = mid+1
                else:
                    end = mid-1
                    
        return -1
    
    #T.C. = O(Log(n))

