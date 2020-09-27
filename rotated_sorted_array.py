"""
Problem - Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
Solution - Apply binary search tree with two situations -
    1. Mid is larger than the first element
    2. Mid is smaller than the first element
Time Complexity - O(log n), where n is the index of the target value
Space Complexity - O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class RotatedSortedArray:
    def search(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = int(start + (end - start)/2)
            # If we find target in the middle number
            if nums[mid] == target:
                return mid
            # If the sorted numbers are before mid
            elif nums[start] <= nums[mid]:
                # If the target is before mid
                if nums[start] <= target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            # If the sorted numbers are after mid
            else:
                # If the target is after mid
                if nums[mid] < target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1


# Driver code
obj = RotatedSortedArray()
print(obj.search([4,5,5,6,7,0,0,1,2,4], 0))
