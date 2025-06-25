# Time Complexity : O(log n) since we discarding one side of the array in each search operation
# Space Complexity : O(1) no additional space is required
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
    # Learned to apply binary search on half sorted array as well instead of just entire sorted array


# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        #linear search will take the O(n) which is the bruteforce solution
        #better approach would be to perform a binary search resulting O(log n) time

        #observation:
        #alteast one side of the array is sorted when divided at the mid
        
        #base case
        if not nums or len(nums) == 0:
            return -1
        
        n = len(nums)
        low = 0
        high = n - 1

        while low <= high:

            #to prevent integer overflow and always stay within the range
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]: #we could have just a single element as well, hence <=
                if target >= nums[low] and target < nums[mid]: #we can ignore <= and just do < since we have already checked for equal in the line 23.
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
