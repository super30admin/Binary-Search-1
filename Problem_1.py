'''
Time Complexity - O(log n)
Space Complexity - O(1)

Code works on leetcode.
'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high  = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low)//2 
            print(mid)
            if nums[mid] ==  target:
                """
                Check if nums[mid] is actually the target value
                """
                return mid
            elif nums[low]<=nums[mid]:
                """
                Check if the left subarray is sorted. if target present in left subarray
                ignore the right subarray 
                else 
                ignore the left subarray
                """
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                """
                Check if the right subarray is sorted. if target present in right subarray
                ignore the left subarray 
                else 
                ignore the right subarray
                """
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1         

        