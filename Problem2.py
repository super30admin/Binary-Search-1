# // Time Complexity : every time elimating one side of the array O(logn)
# // Space Complexity : No exra space , just using variable slow, high , mid which is a constant O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No

class Problem2(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # key conecpet in rotate sorted array, where ever we are in the loop at least onse side will always be sorted

        low = 0
        high = len(nums)-1

        while ( low<=high):
            mid = low + ( high-low)/2

            if nums[mid] == target: # if we found the target return the index
                return mid
           
            # if not found, find which side is sorted

            if nums[low] <= nums[mid] : # left array is sorted
                if nums[low] <= target and nums[mid] > target: #  means from left to mid, somehwre the target exists
                    high = mid-1 # elimiating the rigth side of the array for searching
                else:
                    low = mid + 1 # so the target is right side of the array

            else: # right aray is sorted
                if nums[mid] < target and target <= nums[high]: 
                    low = mid +1
                else:
                    high = mid-1

        return -1 # if not found return -1

            