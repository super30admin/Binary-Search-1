# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Logic: find the middle element, due to rotation either left or mid would be sorted or right of mid would be sorted
# locate in which region target lies & discard the other region. Keep on searching for the element in the sorted part
# keep on changing the range for the middle element. If found return index else -1

class Solution:
    def search(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end-start)//2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[start]:
                if nums[start] <= target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if nums[mid] < target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1
