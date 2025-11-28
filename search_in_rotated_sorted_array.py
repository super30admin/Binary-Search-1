#  https://leetcode.com/problems/search-in-rotated-sorted-array/


# In this problem either one part of the binary search is going to be the sorted. So find the mid element at first and check which part is sorted. Once we get the sorted part check the target is present or not and accordingly move the pointer to the either sides. complexity O(log n)


# why we cant do the normal binary search: Because it can be applied on the sorted here and here the one half is not sorted
# that is why we are adding two extra checks and do the binary only in the valid not for the all means we are handeling the situation in such a way that it should check only in the sorted half


# to check whether the left is sorted 
# if nums[low] <= nums[mid_index]:
# and its else condition where right is sorted
# second check is if nums[low] <= target < nums[mid_index]: which is sorted half to decide which side to search

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        # initialising low and high
        low = 0
        high = len(nums) - 1
        # loop till high doesn't cross the low
        while low <= high:
            # finding the middle index for binary search
            mid_index = (low + high) // 2
            # first check if the target is equal to middle element no need to iterate left or right part return the mid_index
            if target == nums[mid_index]:
                return mid_index
            
            # check whether the left side is sorted
            if nums[low] <= nums[mid_index]:
                # check target is present in the left side
                if nums[low] <= target < nums[mid_index]:
                    # now the target is in left side so move the high pointer to the left because we are considering left range for the search
                    high = mid_index - 1
                # if target is not in the left side then move the low pointer to right side because we are considering right range for the search
                else:
                    low = mid_index + 1
            # else the first element is greater than middle means right side sorted 
            else:
                # check target is present in the right side
                if nums[mid_index] < target <= nums[high]:
                    # now the target is in right part so move the mid to the right because we are considering right range for the search
                    low = mid_index + 1
                # if target is not in the right part then move the high pointer to left side because we are considering left range for the search
                else: 
                    high = mid_index - 1 

        return -1

op = Solution()
print(op.search([4,5,6,7,0,1,2], 0))
# Output: 4
        