# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach


        low = 0

        high = len(nums) - 1

        while(low <= high):

            mid = low + (high - low)//2 # manage integer overflow for large integers

            if nums[mid] == target:

                return mid

            elif nums[low] <= nums[mid]:

                if nums[low] <= target and target <= nums[mid]: #left

                    high = mid - 1 # forget right half

                else:

                    low = mid + 1 # forget left half

            else:

                if nums[mid] <= target and target <= nums[high]: # right sorted

                    low = mid + 1 # forget left half

                else:

                    high = mid - 1 # forget right half

        return -1