#time complexity - O(long n) where n is the number of elements in nums list
#space complexity - O(1) because it uses constant space
#Submit on leetcode - yes

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        
        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high-low)//2
            
            if nums[mid] == target:
                return mid

            elif nums[low] <= nums[mid]:
                # if target is in left side
                if nums[low] <= target and nums[mid] >= target:
                    high = mid-1
                else:
                    low = mid+1
                        
            else:
                 # if target is in right side
                if nums[high] >= target and nums[mid] <= target:
                    low = mid+1
                else:
                    high = mid -1
           
        return -1
        
sol = Solution()
nums = [4, 5, 6, 7, 0, 1, 2]
target = 7
result = sol.search(nums, target)
print(f"Index of {target}: {result}")


