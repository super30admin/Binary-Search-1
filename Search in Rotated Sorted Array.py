# time complexity : O(log n)
# space complexity: O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums)-1
        
        while(l<=r):
            mid = l + (r-l)//2
            if nums[mid] == target:
                return mid
            elif nums[l]<= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid +1
                    
            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
                    
        return -1