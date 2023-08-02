# Time Complexity : O(log(n)) where n is the number of elements in the array, log because each comparison reduces the search space by half
# Space Complexity : O(1) as we do it in constant space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I tried brute force first by traversing the entrire array and comparing it but then realized that the array can be partially sorted and used binary search


# Your code here along with comments explaining your approach in three sentences only 
# Search Rotated Sorted Array
# The main idea here is to figure out which side of the array is sorted and then apply binary search, we can figure out the sorted side by comparing the mid element with the low element. 
# Then apply binary search on the sorted side and if the target is not in the sorted side, then apply binary search on the other side. 

from typing import List

def search(nums: List[int], target: int) -> int:
    
    # Base case
    if nums is None or len(nums) == 0:
        return -1
    
    # Set low and high 
    low = 0
    high = len(nums) - 1

    # Binary search algo

    while low <= high:
        # Calculate mid 

        mid = low + (high - low) // 2 # To prevent integer overflow 

        # If the mid is the target, return the index
        if target == nums[mid]:
            return mid

        # Now if the left side of the array is sorted

        if nums[low] <= nums[mid]:
                
            # if the target is present in the left sorted portion, we go left as it is in the left side
            if target < nums[mid] and target >= nums[low]:
                high = mid - 1

            else:
                # We go right
                low = mid + 1

        # if not, that means the right side is sorted
        else:
            # if the target is present in the right sorted portion, we go right else we go left

            if target > nums[mid] and target <= nums[high]:
                low = mid + 1

            else:
                high = mid - 1


    return -1 # If the target is not present


