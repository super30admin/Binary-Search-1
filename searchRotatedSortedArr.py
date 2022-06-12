"""
Approach 1: O(n) Brute force : just go one element at a time and find the number. If you reach end of the list, return -1
Approach 2: O(log n) Binary Search: Even in an sorted rotated array you can find which half is sorted and if the target element
is in that range then you can run binary search on that part
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = len(nums)
        # Base case 
        if l == 0:
            return -1
        elif l == 1:
            if nums[0] == target:
                return 0
            return -1
        
        l, h = 0, l - 1
        
        while l <= h:
            m = l +(h-l)//2
            if nums[m] == target:
                return m
            # check if the left half is sorted by comparing low and mid
            elif nums[l] <= nums[m]:   # left sorted
                # if number in the range of low to mid, lower the high = mid -1
                if nums[l] <= target and nums[m] > target:
                    h = m - 1
                else: # increase the low
                    l = m + 1
            #assume right half is sorted 
            # because approach is to basically find a sorted half and run binary search on it
            else: # right sorted
                if nums[m] < target and nums[h] >= target:
                    l = m + 1
                else:
                    h = m - 1
        return -1

