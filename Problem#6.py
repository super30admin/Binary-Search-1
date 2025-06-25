# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did you run the code on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only


'''
33. Search in Rotated Sorted Array
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0: # We check if the list is empty or if the length of the list is zero
            return -1 # If the list is empty, we return -1 as the target cannot be found
        n = len(nums) # We store the length of the list in a variable n
        low = 0 # We initialize low variable to 0, which represents the starting index of the list
        high = n - 1 # We initialize high variable to n - 1, which represents the ending index of the list
        while low <= high: # Until low index is less than or equal to high index we continue the search
            mid = (low + high) // 2 # We calculate the mid index by taking the average of low and high indices
            if nums[mid] == target: # If the mid index value is equal to the target value, we have found the target here itself
                return mid # We return the mid index as the target is found at this index
            elif nums[low] <= nums[mid]: # Left side is sorted # We check if the left side of the mid index is sorted
                if nums[low] <= target < nums[mid]: # Then we further check in the left side that if the target is in the range of low and mid indices
                    high = mid - 1 # If the target is in the range, we move the high index to mid - 1 to search in the left side
                else: # If the target is not in the range, we move the low index to mid + 1 to search in the right side
                    low = mid + 1 # We move the low index to mid + 1 to search in the right side
            else: # Right side is sorted # If the left side is not sorted, then the right side must be sorted
                if nums[mid] < target <= nums[high]: # We check if the target is in the range of mid and high indices
                    low = mid + 1 # If the target is in the range, we move the low index to mid + 1 to search in the right side
                else: # If the target is not in the range, we move the high index to mid - 1 to search in the left side
                    high = mid -1 # We move the high index to mid - 1 to search in the left side
        return -1   # If we exit the while loop, it means the target is not found in the list, so we return -1                           
