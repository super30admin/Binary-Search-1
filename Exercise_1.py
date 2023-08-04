# Problem1
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, nums, target):
        # checking if array is empty
        if len(nums) == 0:
            # not in nums
            return -1
        # taking two ptrs low
        low = 0
        # and high
        high = len(nums) - 1
        # while loop
        while (low <= high):
            # calculating mid
            mid = (low + high) // 2
            # if mid has target
            if nums[mid] == target:
                # target in nums return mid
                return mid
            # check if left sorted
            elif (nums[low] <= nums[mid]):
                # left sorted
                # check if target present in left part
                if (target >= nums[low] and target < nums[mid]):
                    # shorten our window by 1/2
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right sorted
                if (target > nums[mid] and target <= nums[high]):
                    # shorten our window by 1/2
                    low = mid + 1
                else:
                    high = mid - 1
        # target not present
        return - 1


nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
sol = Solution()
print(sol.search(nums=nums, target=target))
