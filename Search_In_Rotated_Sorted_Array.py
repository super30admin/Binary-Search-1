
# Time Complexity : O(logn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach :
            # 1. The main idea of this problem is one half of the array is sorted and the other is unsorted. We check which part is sorted by comparung if its lower bound is less than higher bound
            # 2. After knowing which part is sorted, check whether the target is in the sorted array or not
            # 3. Accordingly manipulate low and high values until low > high.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1
        while low <= high:
            mid = low + int((high - low) / 2)
            # found target
            if nums[mid] == target:
                return mid
            # left subarray is sorted
            elif nums[mid] >= nums[low]:
                # check if target is in the bounded range of sorted left subarray
                if nums[low] <= target and nums[mid] > target:
                    # limit search to left subarray by moving high
                    high = mid -1
                # if target is not present in the bounded range of sorted left subarray then move to right
                else:
                    low = mid + 1
            # right part is sorted
            else:
                # check if target is in the bounded range of sorted right subarray
                if nums[mid] <= target and nums[high] >= target:\
                    # move to right
                    low = mid + 1
                # move to left unsorted subarray
                else:
                    high = mid - 1 
        # target is not in the sorted rotated array
        return -1
        