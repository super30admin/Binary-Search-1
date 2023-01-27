# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : The mid value remains in float data type if I do not apply type cast to it


# // Your code here along with comments explaining your approach in three sentences only



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None or len(nums)==0: # checking the condition if there is empty list
            return -1
        low = 0
        high = len(nums) - 1
        while(low <= high): # The loop is iterated until the mid is equal to the target
            mid = int((low + high)/2) # calculating the mid and checking below if value of mid is equal to target
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]: # checking if the array is sorted on the left side, if it is then checking if target exists between the left sorted array
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target: # similarly this is the right sorted array and same logic is applied here as left sorted array
                    low = mid + 1
                else:
                    high = mid - 1
        return -1 # if none of the conditions are met, the function returns -1