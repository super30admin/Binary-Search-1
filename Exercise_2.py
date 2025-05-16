# Time Complexity - O(log (n))
# Space Complexity - O(1)
class Solution(object):
    def search(self, nums, target):

        l , r = 0, len(nums) - 1


        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                return mid

            elif nums[l] <= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid -1
                else:
                    l = mid + 1

            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid -1
        return -1  


nums = [4,5,6,7,0,1,2]
target = 0
sol = Solution()
result = sol.search(nums, target)
print(result)