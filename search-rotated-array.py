# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leet code : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
	# check if the input array is empty or not and returns -1 if empty
        if nums == None or len (nums) == 0: 
            return -1
        
	# calculate length of array, low and high values for binary search
        n = len(nums)
        low = 0
        high = n - 1

	# perform binary search until the low is less than equal to high to search for the element else return -1
        while low <= high:
	    # calculate mid element
            mid= low + (high - low) // 2 # avoid integer overflow

	    # if target is equal to the mid element return mid else change low and high values based on conditions
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]: 
                if target >= nums[low] and target< nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1
            else: 
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else: 
                    high = mid - 1
        return -1