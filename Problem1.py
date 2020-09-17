# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : It took me 40 mins to get the approach. Previously was doing in O(n)


# // Your code here along with comments explaining your approach: 
# 1. Evaluated cases: 
#     1. target < mid , target < start
#     2. target < mid , target < start 
#     3. target > mid , target > start 
#     4. target > mid , target < start 
# 2. Optimised 5 if else to nested if else and also straightened my comparison by comparing mid and start instead of target and start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums)-1
        while start <= end:
            mid = start + (end - start) // 2
            if target == nums[mid]:
                return mid
            if nums[mid] >= nums[start]:
                if target >= nums[start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if target > nums[mid] and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1