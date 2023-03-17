class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums==None or len(nums)==0:
            return -1
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid
            
            if nums[low]<=nums[mid]: #check if left sorted
                if target >= nums[low] and target <nums[mid]: #if target exists in sorted part
                    high=mid-1
                else:
                    low=mid+1
            else:#right is sorted
                if target >nums[mid] and target <=nums[high]: #if target exists in sorted part
                    low=mid+1
                else:
                    high=mid-1
        
        return -1

#time complexity=0(logN)
#space complexity=0(1)