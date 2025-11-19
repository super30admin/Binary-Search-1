'''
Searching a target element in an array. Since the array is sorted we can use binary search technique to find the target value.
we consider 2 pointers low and high, we compare the mid and low pointer values to the target and ignore half of the array each time.
If left sorted:
if target value is greater than low value and mid value is grater than target value then we move the high pointer to mid-1 else low pointer to mid+1
If right sorted:
if target value is greater than mid value and high value is greater than target value then we move the low pointer to mid+1 else high pointer to mid-1 
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low+high)//2
            # comparing target with mid value
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # left sorted array
                if nums[low] <= target and nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1
            else:
                # right sorted array
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid -1
        return -1
'''
Time Complexity: O(log n)
Space Complexity: O(1)
'''