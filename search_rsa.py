class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left, right = 0, len(nums) - 1
        n = len(nums)
        
        while left <= right:
            mid = (left+right) //2
            
            if nums[mid] > nums[-1]:
                left = mid + 1
            else:
                right = mid -1
                
        def binarySearch(lb, rb, target):
            left, right = lb, rb
            
            while left <= right:
                mid = (left+right)//2
                if nums[mid] == target:
                    return mid
                elif nums[mid] > target:
                    right = mid -1
                else:
                    left = mid + 1
                    
            return -1
        
        answer =binarySearch(0, left-1, target)
        if answer != -1:
            return answer
        
        return binarySearch(left, n-1, target)
